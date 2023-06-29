
const fetchCoursesBtn = document.getElementById('fetchCoursesBtn');
const showCoursesFormBtn = document.getElementById('showCoursesFormBtn');

const allCoursesDiv = document.getElementById('allCoursesDiv');
const createCourseDiv = document.getElementById('createCourseDiv');

const createCourseForm = document.getElementById('createCourseForm');
const updateCourseForm = document.getElementById('updateCourseForm');
const cancelCreateBtn = document.getElementById('cancelCreateBtn');

let btn3 = document.getElementById("update-course-btn");
let btn4 = document.getElementById("delete-course-btn");


// fetch all courses
function fetchCourses() {

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
}

fetchCoursesBtn.addEventListener('click', fetchCourses);


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

  fetch(`/courses/${courseId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      name: courseName,
      code: courseCode
    })
  })
  .then(response => {
    if (response.ok) {
      fetchCourses();
    } else {
      console.error('Error:', response.statusText);
    }
  })
  .catch(error => {
    console.error('Error:', error);
  });
}


// Delete course
function deleteCourse(courseId) {

  if (!confirm('Are you sure you want to delete this course?')) return;

  fetch(`/courses/${courseId}`, {
    method: 'DELETE'
  })
    .then(response => {
      if (response.ok) {
        fetchCourses();
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

  const updateCourseForm = document.getElementById('updateCourseDiv');
  const updateCourseIdInput = document.getElementById('updateCourseId');
  const updateCourseNameInput = document.getElementById('updateCourseName');
  const updateCourseCodeInput = document.getElementById('updateCourseCode');


  // Update course event listener
  coursesTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('updateCourseBtn')) {
      const courseId = event.target.dataset.id;
      const courseName = event.target.dataset.name;
      const courseCode = event.target.dataset.code;

      console.log(courseId, courseName, courseCode);

      // Populate the update form with course values
      updateCourseIdInput.value = courseId;
      updateCourseNameInput.value = courseName;
      updateCourseCodeInput.value = courseCode;

      updateCourseForm.style.display = 'block';
      allCoursesDiv.style.display = 'none';
    }
  });

  // Update form submit event listener
  updateCourseForm.addEventListener('submit', event => {
    event.preventDefault();

    const updatedCourseId = updateCourseIdInput.value;
    const updatedCourseName = updateCourseNameInput.value;
    const updatedCourseCode = updateCourseCodeInput.value;

    updateCourse(updatedCourseId, updatedCourseName, updatedCourseCode);

    updateCourseForm.style.display = 'none';
  });


  // Delete course event listener
  coursesTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('deleteCourseBtn')) {
      const courseId = event.target.dataset.id;
      deleteCourse(courseId);
    }
  });
});
