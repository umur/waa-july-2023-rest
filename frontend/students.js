const BASE_URL = 'http://localhost:8080';

document.addEventListener('DOMContentLoaded', function() {
    fetchStudents();
    document.getElementById('addStudentForm').addEventListener('submit', addStudent);
    document.getElementById('getStudentsByMajorForm').addEventListener('submit', getStudentsByMajor);
    document.getElementById('getCoursesByStudentIdForm').addEventListener('submit', getCoursesByStudentId);
});

function fetchStudents() {
    fetch(`${BASE_URL}/students`)
        .then(response => response.json())
        .then(data => {
            const studentsBody = document.getElementById('studentsBody');
            studentsBody.innerHTML = '';

            data.forEach(student => {
                const row = createStudentRow(student);
                studentsBody.appendChild(row);
            });
        })
        .catch(error => displayErrorMessage('Error fetching students'));
}

function addStudent(event) {
    event.preventDefault();

    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const major = document.getElementById('major').value;

    const student = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        major: major
    };

    fetch(`${BASE_URL}/students`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(student)
    })
        .then(response => {
            if (response.ok) {
                document.getElementById('firstName').value = '';
                document.getElementById('lastName').value = '';
                document.getElementById('email').value = '';
                document.getElementById('major').value = '';

                fetchStudents();
            } else {
                response.json().then(errorResponse => {
                    throw new Error(errorResponse.errorMessage || 'Error adding student');
                });
            }
        })
        .catch(error => displayErrorMessage(error.message || 'Error adding student'));
}

function deleteStudent(studentId) {
    if (confirm('Are you sure you want to delete this student?')) {
        fetch(`${BASE_URL}/students/${studentId}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    fetchStudents();
                } else {
                    throw new Error('Error deleting student');
                }
            })
            .catch(error => displayErrorMessage(error.message || 'Error deleting student'));
    }
}

function editStudent(studentId) {
    fetch(`${BASE_URL}/students/${studentId}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error getting student information');
            }
        })
        .then(student => {
            document.getElementById('firstName').value = student.firstName;
            document.getElementById('lastName').value = student.lastName;
            document.getElementById('email').value = student.email;
            document.getElementById('major').value = student.major;
			document.getElementById('id').value = studentId;
			document.getElementById('submit').innerText = 'Update Student';

            const form = document.getElementById('addStudentForm');
            form.removeEventListener('submit', addStudent);
            form.addEventListener('submit', event => updateStudent(event, studentId));
        })
        .catch(error => displayErrorMessage(error.message || 'Error getting student information'));
}

function updateStudent(event, studentId) {
    event.preventDefault();

    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const major = document.getElementById('major').value;
	const id = document.getElementById('id').value;
    const student = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        major: major,
		id: id
    };

    fetch(`${BASE_URL}/students/${studentId}`, {
        method: 'PUT',
       headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(student)
    })
        .then(response => {
            if (response.ok) {
                document.getElementById('firstName').value = '';
                document.getElementById('lastName').value = '';
                document.getElementById('email').value = '';
                document.getElementById('major').value = '';
				document.getElementById('id').value = '';
				document.getElementById('submit').innerText = 'Add Student';

                const form = document.getElementById('addStudentForm');
                form.removeEventListener('submit', updateStudent);
                form.addEventListener('submit', addStudent);

                fetchStudents();
            } else {
                response.json().then(errorResponse => {
                    throw new Error(errorResponse.errorMessage || 'Error updating student');
                });
            }
        })
        .catch(error => displayErrorMessage(error.message || 'Error updating student'));
}

function getStudentsByMajor(event) {
    event.preventDefault();

    const major = document.getElementById('majorFilter').value;

    fetch(`${BASE_URL}/students/getStudentsByMajor?major=${encodeURIComponent(major)}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error getting students by major');
            }
        })
        .then(data => {
            const studentsByMajorResult = document.getElementById('studentsByMajorResult');
            studentsByMajorResult.innerHTML = '';

            data.forEach(student => {
                const result = `<p>${student.firstName} ${student.lastName}</p>`;
                studentsByMajorResult.innerHTML += result;
            });
        })
        .catch(error => displayErrorMessage(error.message || 'Error getting students by major'));
}

function getCoursesByStudentId(event) {
    event.preventDefault();

    const studentId = document.getElementById('studentId').value;

    fetch(`${BASE_URL}/students/${studentId}/courses`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error getting courses by student ID');
            }
        })
        .then(data => {
            const coursesByStudentIdResult = document.getElementById('coursesByStudentIdResult');
            coursesByStudentIdResult.innerHTML = '';

            data.forEach(course => {
                const result = `<p>${course.name} (${course.code})</p>`;
                coursesByStudentIdResult.innerHTML += result;
            });
        })
        .catch(error => displayErrorMessage(error.message || 'Error getting courses by student ID'));
}

function displayErrorMessage(message) {
    const errorDiv = document.createElement('div');
    errorDiv.className = 'error';
    errorDiv.textContent = message;

    const container = document.querySelector('.container');
    container.insertBefore(errorDiv, container.firstChild);

    setTimeout(() => {
        errorDiv.remove();
    }, 3000);
}

function createStudentRow(student) {
    const row = document.createElement('tr');

    const idCell = document.createElement('td');
    idCell.textContent = student.id;
    row.appendChild(idCell);

    const firstNameCell = document.createElement('td');
    firstNameCell.textContent = student.firstName;
    row.appendChild(firstNameCell);

    const lastNameCell = document.createElement('td');
    lastNameCell.textContent = student.lastName;
    row.appendChild(lastNameCell);

    const emailCell = document.createElement('td');
    emailCell.textContent = student.email;
    row.appendChild(emailCell);

    const majorCell = document.createElement('td');
    majorCell.textContent = student.major;
    row.appendChild(majorCell);

    const actionsCell = document.createElement('td');
    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete';
	deleteButton.className = 'btn btn-danger btn-sm';
    deleteButton.addEventListener('click', () => deleteStudent(student.id));
    actionsCell.appendChild(deleteButton);

    const editButton = document.createElement('button');
    editButton.textContent = 'Edit';
    editButton.className = 'btn btn-primary btn-sm mr-2';	
    editButton.addEventListener('click', () => editStudent(student.id));
    actionsCell.appendChild(editButton);

    row.appendChild(actionsCell);

    return row;
}
