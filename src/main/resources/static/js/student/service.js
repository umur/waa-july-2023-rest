import client from "../client.js";

function getStudents(major) {
  return client.get(major ? `/students/?major=${major}` : "/students/");
}

function getStudent(id) {
  return client.get(`/students/${id}`);
}

function deleteStudent(id) {
  return client.del(`/students/${id}`);
}

function updateStudent(student) {
  return client.put(`/students/${student.id}`, student);
}
function addStudent(student) {
  return client.post(`/students/`, student);
}

export default {
  getStudents,
  deleteStudent,
  getStudent,
  updateStudent,
  addStudent,
};
