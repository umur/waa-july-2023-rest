import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Col, Row } from "react-bootstrap";
import AddStudent from "./Components/AddStudent";
import { useEffect, useState } from "react";
import ViewStudents from "./Components/ViewStudents";

function App() {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    refetch();
  }, []);

  const refetch = async () => {
    const res = await fetch("http://localhost:8080/students");
    const jsonData = await res.json();
    setStudents(jsonData);
  };

  return (
    <div>
      <Row>
        <Col>
          <AddStudent refetch={refetch} />
        </Col>
        <Col>
          <ViewStudents students={students} refetch={refetch} />
        </Col>
      </Row>
    </div>
  );
}

export default App;
