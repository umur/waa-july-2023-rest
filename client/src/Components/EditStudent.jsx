import React, { useEffect, useState } from "react";
import {
  Button,
  Col,
  Form,
  Modal,
  ModalBody,
  ModalFooter,
  ModalHeader,
  Row,
} from "react-bootstrap";
import AddCourses from "./AddCourses";

function EditStudent({ refetch, student, show, setShow }) {
  const [state, setState] = useState({});
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    if (!show) return;

    setState(student);
    setCourses(student.coursesTaken);
  }, [show]);

  const handleChange = (e) => {
    setState((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  async function postData(url = "", data = {}) {
    const response = await fetch(url, {
      method: "PUT",
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
    await postData(`http://localhost:8080/students/${student.id}`, data);
    setShow(false);
    refetch();
  };

  return (
    <Modal show={show} onHide={() => setShow(false)} size="xl">
      <Form className="p-2" onSubmit={handleSubmit}>
        <Modal.Header>
          <h3 className="text-center">Update Student</h3>
        </Modal.Header>
        <Modal.Body>
          <Row>
            <Col className="pr-3">
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
            </Col>
            <Col>
              <AddCourses {...{ courses, setCourses }} />
            </Col>
          </Row>
        </Modal.Body>
        <Modal.Footer>
          <Button
            type="button"
            variant="secondary"
            onClick={() => setShow(false)}
          >
            Cancel
          </Button>
          <Button type="submit">Update Student</Button>
        </Modal.Footer>
      </Form>
    </Modal>
  );
}

export default EditStudent;
