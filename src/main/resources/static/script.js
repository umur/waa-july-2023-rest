
const fetchCoursesBtn = document.getElementById('fetchCoursesBtn');
const showCoursesFormBtn = document.getElementById('showCoursesFormBtn');

const allCoursesDiv = document.getElementById('allCoursesDiv');
const createCourseDiv = document.getElementById('createCourseDiv');

const createCourseForm = document.getElementById('createCourseForm');
const cancelCreateBtn = document.getElementById('cancelCreateBtn');

let btn3 = document.getElementById("update-course-btn");
let btn4 = document.getElementById("delete-course-btn");


// fetch all courses
fetchCoursesBtn.addEventListener('click', () => {

  allCoursesDiv.style.display = 'block';
  createCourseDiv.style.display = 'none';

  fetch('/courses')
      .then(response => response.json())
      .then(courses => {
          const tableBody = document.getElementById('coursesTableBody');
          tableBody.innerHTML = '';
          courses.forEach(course => {
              appendCourseToTable(course, tableBody);
          });
      })
      .catch(error => {
          console.error('Error:', error);
      });
});


showCoursesFormBtn.addEventListener('click', () => {
  allCoursesDiv.style.display = 'none';
  createCourseDiv.style.display = 'block';
});

cancelCreateBtn.addEventListener('click', () => {
  createCourseForm.reset();
  allCoursesDiv.style.display = 'block';
  createCourseDiv.style.display = 'none';
});

// Create a new course
createCourseForm.addEventListener('submit', event => {

  event.preventDefault();

  const id = document.getElementById('idInput').value;
  const name = document.getElementById('nameInput').value;
  const code = document.getElementById('codeInput').value;

    const newCourse = {
      id: id,
      name: name,
      code: code
    };

    fetch('/courses', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newCourse)
    })
      .then(response => response.json())
      .then(course => {
        const tableBody = document.getElementById('coursesTableBody');
        appendCourseToTable(course, tableBody);
        createCourseForm.reset();
        allCoursesDiv.style.display = 'block';
        createCourseDiv.style.display = 'none';
      })
      .catch(error => {
        console.error('Error:', error);
      });
});

// Function to append a course to the table
function appendCourseToTable(course, tableBody) {
  const row = document.createElement('tr');
  row.innerHTML = `
      <td>${course.id}</td>
      <td>${course.name}</td>
      <td>${course.code}</td>
      <td><button class="btn btn-primary updateCourseBtn" data-id="${course.id}" data-name="${course.name}" data-code="${course.code}">Update</button></td>
      <td><button class="btn btn-danger deleteCourseBtn" data-id="${course.id}">Delete</button></td>
  `;
  tableBody.appendChild(row);
}


// Update course
function updateCourse(courseId, courseName, courseCode) {

  console.log('Updating course with ID:', courseId);

  // Update an existing course
  const updatedCourse = {
    id: courseId,
    name: courseName,
    code: courseCode
  };

  fetch('/courses/'+updatedCourse.id, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(updatedCourse)
  })
    .then(response => response.json())
    .then(course => {
      console.log(course);
      // Process the updated course
    })
    .catch(error => {
      console.error('Error:', error);
    });
}


// Delete course
function deleteCourse(courseId) {

  if (!confirm('Are you sure you want to delete this course?')) return;

  fetch('/courses/'+courseId, {
    method: 'DELETE'
  })
    .then(response => {
      if (response.ok) {
        location.reload();
      } else {
        console.error('Error:', response.statusText);
      }
    })
    .catch(error => {
      console.error('Error:', error);
    });
}


document.addEventListener('DOMContentLoaded', () => {
  const coursesTableBody = document.getElementById('coursesTableBody');

  // Update course event listener
  coursesTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('updateCourseBtn')) {
      const courseId = event.target.dataset.id;
      const courseName = event.target.dataset.name;
      const courseCode = event.target.dataset.code;
      updateCourse(courseId, courseName, courseCode);
    }
  });

  // Delete course event listener
  coursesTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('deleteCourseBtn')) {
      const courseId = event.target.dataset.id;
      deleteCourse(courseId);
    }
  });
});
