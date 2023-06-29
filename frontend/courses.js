const BASE_URL = 'http://localhost:8080';
document.addEventListener('DOMContentLoaded', function() {
    fetchCourses();
    document.getElementById('addCourseForm').addEventListener('submit', addCourse);
});

function fetchCourses() {
    fetch(`${BASE_URL}/courses`)
        .then(response => response.json())
        .then(data => {
            const coursesBody = document.getElementById('coursesBody');
            coursesBody.innerHTML = '';

            data.forEach(course => {
                const row = createCourseRow(course);
                coursesBody.appendChild(row);
            });
        })
        .catch(error => displayErrorMessage('Error fetching courses'));
}

function addCourse(event) {
    event.preventDefault();

    const name = document.getElementById('courseName').value;
    const code = document.getElementById('courseCode').value;

    const course = {
        name: name,
        code: code
    };

    fetch(`${BASE_URL}/courses`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(course)
    })
        .then(response => {
            if (response.ok) {
                document.getElementById('courseName').value = '';
                document.getElementById('courseCode').value = '';

                fetchCourses();
            } else {
                response.json().then(errorResponse => {
                    throw new Error(errorResponse.errorMessage || 'Error adding course');
                });
            }
        })
        .catch(error => displayErrorMessage(error.message || 'Error adding course'));
}

function deleteCourse(id) {
    if (confirm('Are you sure you want to delete this course?')) {
        fetch(`${BASE_URL}/courses/${id}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    fetchCourses();
                } else {
                    throw new Error('Error deleting course');
                }
            })
            .catch(error => displayErrorMessage(error.message || 'Error deleting course'));
    }
}

function editCourse(id) {
    fetch(`${BASE_URL}/courses/${id}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error getting course information');
            }
        })
        .then(course => {
            document.getElementById('courseName').value = course.name;
            document.getElementById('courseCode').value = course.code;
            document.getElementById('id').value = id;
            document.getElementById('addCourseButton').innerText = 'Update Course';
			
			const form = document.getElementById('addCourseForm');
            form.removeEventListener('submit', addCourse);
            form.addEventListener('submit', event => updateCourse(event, id));
        })
        .catch(error => displayErrorMessage(error.message || 'Error getting course information'));
}

function updateCourse(event) {
    event.preventDefault();

    const id = document.getElementById('id').value;
    const name = document.getElementById('courseName').value;
    const code = document.getElementById('courseCode').value;

    const course = {
        name: name,
        code: code,
		id: id
    };

    fetch(`${BASE_URL}/courses/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(course)
    })
        .then(response => {
            if (response.ok) {
                document.getElementById('courseName').value = '';
                document.getElementById('courseCode').value = '';
                document.getElementById('id').value = '';
                document.getElementById('addCourseButton').innerText = 'Add Course';
				
				const form = document.getElementById('addCourseForm');
                form.removeEventListener('submit', updateCourse);
                form.addEventListener('submit', addCourse);

                fetchCourses();
            } else {
                response.json().then(errorResponse => {
                    throw new Error(errorResponse.errorMessage || 'Error updating course');
                });
            }
        })
        .catch(error => displayErrorMessage(error.message || 'Error updating course'));
}

function createCourseRow(course) {
    const row = document.createElement('tr');

    const idCell = document.createElement('td');
    idCell.textContent = course.id;
    row.appendChild(idCell);

    const nameCell = document.createElement('td');
    nameCell.textContent = course.name;
    row.appendChild(nameCell);

    const codeCell = document.createElement('td');
    codeCell.textContent = course.code;
    row.appendChild(codeCell);

    const actionsCell = document.createElement('td');
    const editButton = document.createElement('button');
    editButton.textContent = 'Edit';
    editButton.className = 'btn btn-primary btn-sm mr-2';
    editButton.addEventListener('click', () => editCourse(course.id));
    actionsCell.appendChild(editButton);

    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete';
    deleteButton.className = 'btn btn-danger btn-sm';
    deleteButton.addEventListener('click', () => deleteCourse(course.id));
    actionsCell.appendChild(deleteButton);

    row.appendChild(actionsCell);

    return row;
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