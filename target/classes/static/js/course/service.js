import client from "../client.js";

function getCourses() {
  return client.get("/courses/");
}

function getCourse(id) {
  return client.get(`/courses/${id}`);
}

function deleteCourse(id) {
  return client.del(`/courses/${id}`);
}

function updateCourse(course) {
  return client.put(`/courses/${course.id}`, course);
}
function addCourse(course) {
  return client.post(`/courses/`, course);
}

export default {
  getCourses,
  deleteCourse,
  getCourse,
  updateCourse,
  addCourse
};
