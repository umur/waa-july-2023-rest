import React from "react";
import { Button, Col, Form, Row } from "react-bootstrap";

const initCourse = () => ({
  id: "",
  name: "",
  code: "",
});

function AddCourses({ courses, setCourses }) {
  const handleAddCourse = () => setCourses((prev) => [...prev, initCourse()]);

  const handleRemoveCourse = (idx) =>
    setCourses((prev) => prev.toSpliced(idx, 1));

  const handleChange = (idx, e) =>
    setCourses((prev) =>
      prev.toSpliced(idx, 1, { ...prev[idx], [e.target.name]: e.target.value })
    );

  return (
    <div>
      <div className="d-grid">
        <Button variant="outline-info" type="button" onClick={handleAddCourse}>
          Add Course
        </Button>
      </div>

      {courses.map((course, index) => (
        <div className="mt-3">
          <Row>
            <Col>
              <h4>Course {index + 1}</h4>
            </Col>
            <Col>
              <div className="d-grid">
                <Button
                  onClick={handleRemoveCourse.bind(this, index)}
                  type="button"
                  variant="outline-danger"
                >
                  Remove
                </Button>
              </div>
            </Col>
          </Row>

          <Form.Group className="mb-2">
            <Form.Label>Course Id</Form.Label>
            <Form.Control
              required
              type="number"
              name="id"
              value={course.id}
              onChange={handleChange.bind(this, index)}
            />
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>Name</Form.Label>
            <Form.Control
              required
              name="name"
              value={course.name}
              onChange={handleChange.bind(this, index)}
            />
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>Code</Form.Label>
            <Form.Control
              required
              name="code"
              value={course.code}
              onChange={handleChange.bind(this, index)}
            />
          </Form.Group>
        </div>
      ))}
    </div>
  );
}

export default AddCourses;
