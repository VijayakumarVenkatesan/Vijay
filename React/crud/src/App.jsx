import { useEffect, useState } from 'react'
import './App.css'

function App() {

  const [name, setName] = useState("")
  const [age, setAge] = useState("")
  const [email, setEmail] = useState("")
  const [phone, setPhone] = useState("")
  const [city, setCity] = useState("")
  const [data,setData]=useState([])
  const [editIndex,setEditIndex]=useState("")
  const [isEdit,setIsEdit]=useState(false)
  const [buttonText,setButtonText]=useState("Submit")

  const handleSubmit=(e)=>{
    e.preventDefault();
    const newEntry={name,age,email,phone,city,isChecked:false}
    if(isEdit){
      const updatedData=data.map((item,index)=>(
        index===editIndex?newEntry:item 
      ))
      setData(updatedData)
      setIsEdit(false)
      setEditIndex("")
      setButtonText("Submit")
    }
    else{
      setData([...data,newEntry])
    }
    setName("")
    setAge("")
    setEmail("")
    setPhone("")
    setCity("")
  }

  const handleChecked=(index)=>{
    const newData=data.map((item,i)=>(
      i===index ? {...item, isChecked: !item.isChecked}: item
    ))
    setData(newData)
  }

  const handleEdit=(index)=>{
    const info=data[index]
    setName(info.name)
    setAge(info.age)
    setEmail(info.email)
    setPhone(info.phone)
    setCity(info.city)
    setIsEdit(true)
    setEditIndex(index)
    setButtonText("Save")
  }

  const handleDelete=()=>{   
    const newData=data.filter((item)=>!item.isChecked)
    setData(newData)
  } 

  const handleDeleteAll=()=>{
    setData([])
  }

  return (
    <>
      <div id="outer">

        <div id="form">
          <table>
            <tr>
              <td></td>
              <td>Form</td>
            </tr>
            <tr>
              <td>Name</td>
              <td><input id="name" placeholder='Enter your name' value={name} onChange={(e)=> setName(e.target.value)} required/></td>
            </tr>
            <tr>
              <td>Age</td>
              <td><input id="age" type="number" placeholder='Enter your age' value={age} onChange={(e)=> setAge(e.target.value)} required/></td>
            </tr>
            <tr>
              <td>Email</td>
              <td><input id="email" type='email' placeholder='Enter your email' value={email} onChange={(e)=> setEmail(e.target.value)} required/></td>
            </tr>
            <tr>
              <td>Phone</td>
              <td><input id="phone" type="number" placeholder='Enter your phone number' value={phone} onChange={(e)=> setPhone(e.target.value)} required/></td>
            </tr>
            <tr>
              <td>City</td>
              <td><input id="city" type='text' placeholder='Enter your city' value={city} onChange={(e)=> setCity(e.target.value)} required/></td>
            </tr>
            <tr>
              <td></td>
              <td><button onClick={handleSubmit}>{buttonText}</button></td>
            </tr>
          </table>
        </div>
        <div id="table">
            <table border='1'>
              <tr>
                <td></td>
                <td>Table</td>
              </tr>
              <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Phone</th>
                <th>City</th>
                <th>Edit</th>
                <th>Select</th>
              </tr>
              {
                data.map((item,index)=>(
                  <tr key={index}>
                    <td>{item.name}</td>
                    <td>{item.age}</td>
                    <td>{item.email}</td>
                    <td>{item.phone}</td>
                    <td>{item.city}</td>
                    <td><button onClick={()=>handleEdit(index)}>Edit</button></td>
                    <td><input type='checkbox' checked={item.isChecked} onChange={()=>handleChecked(index)}/></td>
                  </tr>
                ))
              }
              <tr>
                <button onClick={()=>handleDelete()}>Delete</button>
                <button onClick={()=>handleDeleteAll()}>Clear All</button>
              </tr>
            </table>
        </div>
      </div>
    </>
  )
}

export default App
