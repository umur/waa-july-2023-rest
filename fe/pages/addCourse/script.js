const form = document.getElementById("form");
form.addEventListener("submit", (e) => {
  e.preventDefault();
  const data = new FormData(e.target);
  const dataObject = Object.fromEntries(data.entries());

  fetch("http://localhost:8080/students", {
    method: "POST",
    body: dataObject,
    headers: { "Content-Type": "application/json" },
  });
  console.log(dataObject);
});
