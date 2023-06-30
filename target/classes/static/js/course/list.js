import courseService from "./service.js";

function getCourses() {
  courseService.getCourses().then((courses) => {
    row(courses);
  });
}

function del(id) {
  courseService.deleteCourse(id).then((x) => {
    getCourses();
  });
}

function row(courses) {
  let row = courses.map((c) => {
    return `<tr>
                <th scope="row">${c.id}</th>
                <td>${c.name}</td>
                <td>${c.code}</td>
                <td>
                  <div>
                    <a href="/page/course/detail.html?id=${c.id}">Edit</a>
                    <a href="#" class="ml-2 course-delete" data-id="${c.id}">Delete</a>
                  </div>
                </td>
            </tr>`;
  });

  document.querySelector("#courses").innerHTML = row.join("");

  if (row.length > 0) {
    let deleteFunction = (event) => {
      if (confirm("Are you sure to delete a course?")) {
        let id = event.target.getAttribute("data-id");
        del(id);
      }
    };

    let deleteLinks = document.getElementsByClassName("course-delete");

    for (const element of deleteLinks) {
      element.addEventListener("click", deleteFunction);
    }
  }
}

(function () {
  getCourses();
})();

