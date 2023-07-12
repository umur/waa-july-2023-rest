
import './App.css'
import Details from './students/Details'
import List from './students/List'
import { BrowserRouter, Routes, Route } from "react-router-dom"


function App() {


  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<List />} />
        <Route path={`/details/:id`} element={<Details />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
