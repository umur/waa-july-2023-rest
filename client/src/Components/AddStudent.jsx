import React, { useState } from "react";
import { Button, Form } from "react-bootstrap";
import AddCourses from "./AddCourses";

const initState = () => ({
  id: "",
  firstName: "",
  lastName: "",
  email: "",
  major: "",
});

function AddStudent({ refetch }) {
  const [state, setState] = useState(initState);
  const [courses, setCourses] = useState([]);

  const handleChange = (e) => {
    setState((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  async function postData(url = "", data = {}) {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });
    return response.json();
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    const data = { ...state, coursesTaken: courses };
    await postData("http://localhost:8080/students", data);
    setState(initState());
    setCourses([]);
    refetch();
  };

  return (
    <Form className="p-5" onSubmit={handleSubmit}>
      <h2>Add Student</h2>

      <Form.Group className="mb-3">
        <Form.Label>Id</Form.Label>
        <Form.Control
          required
          type="number"
          name="id"
          value={state.id}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>First Name</Form.Label>
        <Form.Control
          required
          name="firstName"
          value={state.firstName}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Last Name</Form.Label>
        <Form.Control
          required
          name="lastName"
          value={state.lastName}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Email address</Form.Label>
        <Form.Control
          required
          type="email"
          name="email"
          value={state.email}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Major</Form.Label>
        <Form.Control
          required
          name="major"
          value={state.major}
          onChange={handleChange}
        />
      </Form.Group>

      <AddCourses {...{ courses, setCourses }} />

      <div className="d-grid mt-3">
        <Button type="submit">Save Student</Button>
      </div>
    </Form>
  );
}

export default AddStudent;
