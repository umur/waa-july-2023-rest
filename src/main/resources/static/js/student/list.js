import studentService from "./service.js";

function getStudents(major) {
  document.getElementById("major").setAttribute("value", major ?? "");
  studentService.getStudents(major).then((students) => {
    row(students);
  });
}

function del(id) {
  studentService.deleteStudent(id).then((x) => {
    getStudents(undefined);
  });
}

function row(students) {
  let row = students.map((s) => {
    return `<tr>
                <th scope="row">${s.id}</th>
                <td>${s.firstName}</td>
                <td>${s.lastName}</td>
                <td>${s.email}</td>
                <td>${s.major}</td>
                <td>${
                  s.coursesTaken
                    ? s.coursesTaken.map((c) => c.code).join(", ")
                    : "None"
                }</td>
                <td>
                  <div>
                    <a href="/page/student/detail.html?id=${s.id}">Edit</a>
                    <a href="#" class="ml-2 student-delete" data-id="${
                      s.id
                    }">Delete</a>
                  </div>
                </td>
            </tr>`;
  });

  document.querySelector("#students").innerHTML = row.join("");

  if (row.length > 0) {
    let deleteFunction = (event) => {
      if (confirm("Are you sure to delete a student?")) {
        let id = event.target.getAttribute("data-id");
        del(id);
      }
    };

    let deleteLinks = document.getElementsByClassName("student-delete");

    for (const element of deleteLinks) {
      element.addEventListener("click", deleteFunction);
    }
  }
}

(function () {
  getStudents(undefined);

  document.getElementById("search-button").addEventListener("click", () => {
    getStudents(document.getElementById("major").value);
  });
})();
