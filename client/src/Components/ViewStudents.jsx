import React, { useState } from "react";
import { Button, Col, Row, Table } from "react-bootstrap";
import EditStudent from "./EditStudent";

function ViewStudents({ students, refetch }) {
  const [selected, setSelected] = useState({});
  const [showEdit, setShowEdit] = useState(false);

  function editStudent(student) {
    setSelected(student);
    setShowEdit(true);
  }

  async function deleteStudent(id) {
    const response = await fetch(`http://localhost:8080/students/${id}`, {
      method: "DELETE",
    });

    refetch();
  }
  return (
    <div className="py-5">
      <h2>Current Students</h2>

      {students?.map((student, index) => (
        <div className="mb-4 shadow rounded-3 px-4 py-3">
          <Row>
            <Col xs={8}>
              <div>
                <strong>Student Id: </strong>
                {student.id}
              </div>
              <div>
                <strong>Name: </strong>
                {student.firstName} {student.lastName}
              </div>
              <div>
                <strong>Email: </strong>
                {student.email}
              </div>
              <div>
                <strong>Major: </strong>
                {student.major}
              </div>
            </Col>
            <Col>
              <div className="d-grid mt-2">
                <Button
                  onClick={deleteStudent.bind(this, student.id)}
                  variant="outline-danger"
                >
                  Delete
                </Button>
              </div>
              <div className="d-grid mt-3">
                <Button
                  onClick={editStudent.bind(this, student)}
                  variant="outline-warning"
                >
                  Edit
                </Button>
              </div>
            </Col>
          </Row>
          {student.coursesTaken?.length > 0 && (
            <>
              <h3>Courses</h3>
              <Table striped bordered hover>
                <tr>
                  <th>Id</th>
                  <th>Name</th>
                  <th>Code</th>
                </tr>

                {student.coursesTaken.map((course, idx) => (
                  <tr>
                    <td>{course.id}</td>
                    <td>{course.name}</td>
                    <td>{course.code}</td>
                  </tr>
                ))}
              </Table>
            </>
          )}
        </div>
      ))}

      <EditStudent
        student={selected}
        setShow={setShowEdit}
        show={showEdit}
        refetch={refetch}
      />
    </div>
  );
}

export default ViewStudents;
