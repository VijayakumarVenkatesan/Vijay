import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [city, setCity] = useState("");
  const [data, setData] = useState([]);
  const [editId, setEditId] = useState(null);
  const [isEdit, setIsEdit] = useState(false);
  const [buttonText, setButtonText] = useState("Submit");

  const fetchData = async () => {
    try {
      const response = await fetch("http://localhost:4000/user");
      if (!response.ok) throw new Error(`Server error: ${response.status}`);
      const result = await response.json();
      setData(result);
    } catch (err) {
      console.log("Error: " + err);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newEntry = { name, age, email, phone, city, isChecked: false };
    try {
      if (isEdit) {
        const res = await fetch(`http://localhost:4000/user/${editId}`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(newEntry),
        });
        if (!res.ok) throw new Error(`Update failed: ${res.status}`);
      } else {
        const res = await fetch("http://localhost:4000/user", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(newEntry),
        });
        if (!res.ok) throw new Error(`Add failed: ${res.status}`);
      }
      await fetchData();
      resetForm();
    } catch (err) {
      console.log("Error: " + err);
    }
  };

  const resetForm = () => {
    setName("");
    setAge("");
    setEmail("");
    setPhone("");
    setCity("");
    setIsEdit(false);
    setEditId(null);
    setButtonText("Submit");
  };

  const handleChecked = (id) => {
    const updated = data.map((item) =>
      item.id === id ? { ...item, isChecked: !item.isChecked } : item
    );
    setData(updated);
  };

  const handleEdit = (user) => {
    setName(user.name);
    setAge(user.age);
    setEmail(user.email);
    setPhone(user.phone);
    setCity(user.city);
    setIsEdit(true);
    setEditId(user.id);
    setButtonText("Save");
  };

  const handleDeleteSelected = async () => {
    const selected = data.filter((item) => item.isChecked);
    try {
      for (let user of selected) {
        await fetch(`http://localhost:4000/user/${user.id}`, {
          method: "DELETE",
        });
      }
      await fetchData();
    } catch (err) {
      console.log("Error deleting selected rows:", err);
    }
  };

  const handleDeleteAll = async () => {
    try {
      for (let user of data) {
        await fetch(`http://localhost:4000/user/${user.id}`, {
          method: "DELETE",
        });
      }
      setData([]);
    } catch (err) {
      console.log("Error deleting all:", err);
    }
  };

  return (
    <div id="outer">
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
              <button onClick={handleSubmit}>{buttonText}</button>
              {isEdit && <button onClick={resetForm}>Cancel</button>}
            </td>
          </tr>
        </tbody>
      </table>

      <br />
      <table border="1" cellPadding="5">
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
          {data.length > 0 ? (
            data.map((item) => (
              <tr key={item.id}>
                <td>{item.name}</td>
                <td>{item.age}</td>
                <td>{item.email}</td>
                <td>{item.phone}</td>
                <td>{item.city}</td>
                <td>
                  <button onClick={() => handleEdit(item)}>Edit</button>
                </td>
                <td>
                  <input
                    type="checkbox"
                    checked={item.isChecked || false}
                    onChange={() => handleChecked(item.id)}
                  />
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="7">No records found</td>
            </tr>
          )}
          <tr>
            <td colSpan="7">
              <button onClick={handleDeleteSelected}>Delete Selected</button>
              <button onClick={handleDeleteAll}>Clear All</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default App;