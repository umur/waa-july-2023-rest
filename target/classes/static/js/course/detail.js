import courseService from "./service.js";

let courseId;

function initCourse(id) {
  courseService.getCourse(id).then((course) => {
    document.getElementsByName("id")[0].setAttribute("value", course.id);
    document.getElementsByName("code")[0].setAttribute("value", course.code);
    document.getElementsByName("name")[0].setAttribute("value", course.name);
  });
}
function getFormData(form) {
  let formData = new FormData(form);

  let obj = {};

  for (let key of formData.keys()) {
    obj[key] = formData.get(key);
  }

  if (courseId) {
    courseService.updateCourse(obj).then((x) => {
      alert("Updated successfully.");
      window.location.href = COURSE_LIST_PATH;
    });
  } else {
    courseService.addCourse(obj).then((x) => {
      alert("Created successfully");
      window.location.href = COURSE_LIST_PATH;
    });
  }
}

(function () {
  const urlParams = new URLSearchParams(window.location.search);
  const id = urlParams.get("id");

  if (id) {
    courseId = id;
    initCourse(id);
  }

  document
    .getElementById("course-form")
    .addEventListener("submit", function (e) {
      e.preventDefault();
      getFormData(e.target);
    });
})();
