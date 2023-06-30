import studentService from "./service.js";
import courseService from "../course/service.js";

let studentId;
let courses = [];

function getCourses(student) {
  courseService.getCourses().then((_courses) => {
    courses = _courses;
    document.getElementById("coursesTaken").innerHTML = _courses
      .map(
        (c) =>
          `<option value="${c.id}" ${
            student === undefined || student.coursesTaken?.findIndex((c2) => c2.id == c.id) == -1
              ? ""
              : "selected"
          }>${c.name}</option>`
      )
      .join("");
  });
}

function initStudent(id) {
  studentService.getStudent(id).then((student) => {
    document.getElementsByName("id")[0].setAttribute("value", student.id);
    document
      .getElementsByName("firstName")[0]
      .setAttribute("value", student.firstName);
    document
      .getElementsByName("lastName")[0]
      .setAttribute("value", student.lastName);
    document.getElementsByName("email")[0].setAttribute("value", student.email);
    document.getElementsByName("major")[0].setAttribute("value", student.major);

    getCourses(student);
  });
}
function getFormData(form) {
  let formData = new FormData(form);

  let obj = {};

  for (let key of formData.keys()) {
    obj[key] = formData.get(key);
  }

  for (let option of document.getElementById("coursesTaken").options) {
    if (option.selected) {
      selected.push(option.value);
    }
  }

  obj["coursesTaken"] = courses.filter(c => selected.includes(c.id.toString()));

  if (studentId) {
    studentService.updateStudent(obj).then((x) => {
      alert("Updated successfully.");
      window.location.href = STUDENT_LIST_PATH;
    });
  } else {
    studentService.addStudent(obj).then((x) => {
      alert("Created successfully");
      window.location.href = STUDENT_LIST_PATH;
    });
  }
}

(function () {
  const urlParams = new URLSearchParams(window.location.search);
  const id = urlParams.get("id");

  if (id) {
    studentId = id;
    initStudent(id);
  } else {
    getCourses(undefined);
  }

  document
    .getElementById("student-form")
    .addEventListener("submit", function (e) {
      e.preventDefault();
      getFormData(e.target);
    });
})();
