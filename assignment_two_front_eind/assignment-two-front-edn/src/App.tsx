import React, { useEffect, useState } from 'react';
import './App.css';
import Student from './types/Student';
import StudentList from './components/Student';
import Course from './types/Course';



const App: React.FC = () => {

  const [students, setStudents] = useState<Student[]>([]);

  const fetchData = () => {
    fetch("http://localhost:8080/students")
      .then(response => {
        return response.json()
      })
      .then(data => {
        setStudents(data);
      })
  }

  useEffect(() => {
    fetchData()

  }, [])

  return (
    <div className='App'>
      {/* <StudentList students={students} /> */}
      {students.length > 0 && (
        <ul>

          {
            students.map((student: Student) => {
              return (
                <div>
                <h1>Name</h1>
                <li>{student.firstName}
                <h2>Courses Taken</h2>
                  <ul>
                    {
                      student.coursesTaken.map((course: Course) => {
                        return (
                          <li>{course.name}</li>
                        )
                      })
                    }
                  </ul>
                </li>
                </div>
              )
            })
          }


        </ul>
      )}
    </div>
  )
}

export default App;
