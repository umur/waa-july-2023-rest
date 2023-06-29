document.addEventListener("DOMContentLoaded", function () {
    var courseTableBody = document.getElementById("courseTableBody");
    var studentTableBody = document.getElementById("studentTableBody");
    function clearCourseForm() {
        document.getElementById("courseForm").reset();
    }
    function refreshCourses() {
        fetch("http://localhost:8080/courses")
            .then(response => response.json())
            .then(courses => {
                courseTableBody.innerHTML = "";
                courses.forEach(course => {
                    var row = document.createElement("tr");
                    row.innerHTML = `
                            <td>${course.id}</td>
                            <td>${course.name}</td>
                            <td>${course.code}</td>
                        `;
                    courseTableBody.appendChild(row);
                });
            });
    }

    function refreshStudents() {
        fetch("http://localhost:8080/students")
            .then(response => response.json())
            .then(students => {
                studentTableBody.innerHTML = "";
                students.forEach(student => {
                    var row = document.createElement("tr");
                    row.innerHTML = `
                            <td>${student.id}</td>
                            <td>${student.firstName}</td>
                            <td>${student.lastName}</td>
                            <td>${student.email}</td>
                            <td>${student.major}</td>
                            <td>${student.coursesTaken.map(course => course.name).join(", ")}</td>
                        `;
                    studentTableBody.appendChild(row);
                });
            });
    }

    refreshCourses();
    refreshStudents();

    function addCourse() {
        var courseName = document.getElementById("courseName").value;
        var courseCode = document.getElementById("courseCode").value;

        var course = {
            name: courseName,
            code: courseCode
        };

        fetch("http://localhost:8080/courses", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(course)
        })
            .then(response => {
                if (response.ok) {
                    $('#addCourseModal').modal('hide');
                    refreshCourses();
                } else {
                    alert("Failed to add course.");
                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }

    function addStudent() {
        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        var email = document.getElementById("email").value;
        var major = document.getElementById("major").value;

        var student = {
            firstName: firstName,
            lastName: lastName,
            email: email,
            major: major
        };

        fetch("http://localhost:8080/students", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(student)
        })
            .then(response => {
                if (response.ok) {
                    $('#addStudentModal').modal('hide');
                    refreshStudents();
                } else {
                    alert("Failed to add student.");
                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }
});