import axios from 'axios'
import React, { useEffect, useState } from 'react'

const View = () => {

  const [data,setData]=useState([])

  const fetchData=async()=>{
    const res=await axios.get("http://localhost:8080/view")
    const Data=await res.data.map((list)=>({...list,isChecked: false}))
    setData(Data)
    console.log(Data)
  }

  const handleChecked=(index)=>{
    const newData=[...data]
    newData[index].isChecked= !newData[index].isChecked
    setData(newData)
  }

  useEffect(()=>{
    fetchData();
  },[])

  return (
    <div>
      <h1>View</h1>
      <table border='1'>
        <thead>
          <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
            <th>Phone</th>
            <th>City</th>
            <th>Edit</th>
            <th>Select</th>
          </tr>
        </thead>
        <tbody>
          {
            data.map((list,index)=>(
              <tr key={index}>
                <td>{list.name}</td>
                <td>{list.age}</td>
                <td>{list.email}</td>
                <td>{list.phone}</td>
                <td>{list.city}</td>
                <td><button>Edit</button></td>
                <td><input type="checkbox" checked={list.isChecked} onChange={()=>handleChecked}/></td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  )
}

export default View