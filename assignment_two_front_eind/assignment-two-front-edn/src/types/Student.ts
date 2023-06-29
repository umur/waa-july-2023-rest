import Course from "./Course";


interface Student{
    id: Number;
    firstName: String;
    lastName: String;
    email: String;
    major: String;
    coursesTaken: Course[]
}

export default Student;