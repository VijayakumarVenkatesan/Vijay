import React, { useEffect } from 'react'
import { useState } from 'react';
import axios from 'axios'

const Form = () => {

    const [name, setName] = useState("");
    const [age, setAge] = useState("");
    const [email, setEmail] = useState("");
    const [phone, setPhone] = useState("");
    const [city, setCity] = useState("");
    const [data, setData] = useState([]);
    const [editIndex, setEditIndex] = useState(null);
    const [isEdit, setIsEdit] = useState(false);
    const [buttonText, setButtonText] = useState("Submit");
    const [isChecked,setIsChecked]=useState(false)

    const handleSubmit=async(e)=>{
        e.preventDefault()
        const entry={name,age:Number(age),email,phone,city}
        if(isEdit){
            const res=await axios.put(`http://localhost:8080/form/${editIndex}`)
        }
        else{
            try{
            const res=await axios.post("http://localhost:8080/form",entry)
            setData([...data,entry])
            setName("")
            setAge("")
            setEmail("")
            setPhone("")
            setCity("")            
            }
            catch(err){
                console.log(err)
            }
        }
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <table border="1" cellPadding="5">
                    <thead>
                        <tr>
                            <th colSpan="2">Form</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Name</td>
                            <td>
                            <input
                                id="name"
                                placeholder="Enter your name"
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                                required
                            />
                            </td>
                        </tr>
                        <tr>
                            <td>Age</td>
                            <td>
                            <input
                                id="age"
                                type="number"
                                placeholder="Enter your age"
                                value={age}
                                onChange={(e) => setAge(e.target.value)}
                                required
                            />
                            </td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>
                            <input
                                id="email"
                                type="email"
                                placeholder="Enter your email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                required
                            />
                            </td>
                        </tr>
                        <tr>
                            <td>Phone</td>
                            <td>
                            <input
                                id="phone"
                                type="number"
                                placeholder="Enter your phone"
                                value={phone}
                                onChange={(e) => setPhone(e.target.value)}
                                required
                            />
                            </td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td>
                            <input
                                id="city"
                                placeholder="Enter your city"
                                value={city}
                                onChange={(e) => setCity(e.target.value)}
                                required
                            />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                            <button type='submit'>{buttonText}</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>

    )
}

export default Form