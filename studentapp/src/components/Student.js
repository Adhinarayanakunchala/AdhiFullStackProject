import React, { useState, useRef } from 'react';
import {  useNavigate } from 'react-router-dom';
import axios from 'axios';


const Student = () => {
  const [student, setStudent] = useState({});
  const id = useRef();
  let navigate = useNavigate();

  const fetchStudent = () => {
    axios
      .get(`http://localhost:1999/students/${id.current.value}`)
      .then(
        (res) => {
          const { data } = res;
          setStudent(data);
        },
        (err) => {
          console.log(err);
        }
      );
  };

  const Home=()=>{
    navigate('/');
  }

  return (
    <>
      <div className="container mt-5">
      <h2  className='text text-center'><span style={{ color: 'yellow' }}>S</span>
          <span style={{ color: 'gray' }}>t</span>
          <span style={{ color: 'blue' }}>u</span>
          <span style={{ color: 'red' }}>d</span>
          <span style={{ color: 'gold' }}>e</span>
          <span style={{ color: 'gray' }}>n</span>
          <span style={{ color: 'blue' }}>t</span>
          <span style={{ color: 'red' }}>D</span>
          <span style={{ color: 'yellow' }}>e</span>
          <span style={{ color: 'blue' }}>t</span>
          <span style={{ color: 'red' }}>a</span>
          <span style={{ color: 'gold' }}>i</span>
          <span style={{ color: 'gray' }}>l</span>
          <span style={{ color: 'blue' }}>s</span></h2>
        <div className="row justify-content-center">
          <div className="col-lg-6">
            <div className="input-group mb-3">
              <input
                type="text"
                className="form-control"
                placeholder="Enter student ID"
                ref={id}
              />
              <div className="input-group-append">
                <button
                  className="btn btn-info"
                  type="button"
                  onClick={fetchStudent}
                >
                  Get Student
                </button>
              </div>
            </div>
            {student.name ? (
              <table className="table table-bordered">
                <tbody>
                  <tr className="table-primary">
                    <th>ID:</th>
                    <td>{student.iD}</td>
                  </tr>
                  <tr className="table-secondary">
                    <th>Name:</th>
                    <td>{student.name}</td>
                  </tr>
                  <tr className="table-primary">
                    <th>Course:</th>
                    <td>{student.course}</td>
                  </tr>
                  <tr className="table-secondary">
                    <th>Sub1:</th>
                    <td>{student.sub1}</td>
                  </tr>
                  <tr className="table-primary">
                    <th>Sub2:</th>
                    <td>{student.sub2}</td>
                  </tr>
                  <tr className="table-secondary">
                    <th>Sub3:</th>
                    <td>{student.sub3}</td>
                  </tr>
                  <tr className="table-primary">
                    <th>Average:</th>
                    <td>{student.average}</td>
                  </tr>
                  <tr className="table-secondary">
                    <th>Total:</th>
                    <td>{student.total}</td>
                  </tr>
                </tbody>
              </table>
            ) : (
              <div className="alert alert-info" role="alert">
                No student data available
              </div>
            )}
          </div>
          <button className="btn btn-secondary btn" onClick={Home}> Home</button>
        </div>
      </div>
    </>
  );
};

export default Student;
