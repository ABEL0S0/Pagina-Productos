import { useState } from "react";
import axios from "axios";


function SignUpForm() {
  const [state, setState] = useState({
    name: "",
    email: "",
    password: "",
    direccion: "",
    telefono: "",
  });

  const handleChange = (evt) => {
    const value = evt.target.value;
    setState({
      ...state,
      [evt.target.name]: value,
    });
  };

  const handleOnSubmit = async (evt) => {
    evt.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8080/usuario/save",
        {
          nombre: state.name,
          correo: state.email,
          contrasena: state.password,
          direccion: state.direccion,
          telefono: state.telefono,
        }
      );

      console.log("User signed up:", response.data);

      // Limpiar los campos solo si es necesario
      // setState({
      //   name: "",
      //   email: "",
      //   password: "",
      //   direccion: "",
      //   telefono: "",
      // });

    } catch (error) {
      console.error('Error during sign up:', error);
      alert('Error al registrarse. Por favor, inténtelo de nuevo más tarde.');
    }
  };

  return (
    <div className="form-container sign-up-container">
      <form onSubmit={handleOnSubmit}>
        <h1>Crear una cuenta</h1>
        <input
          type="text"
          name="name"
          value={state.name}
          onChange={handleChange}
          placeholder="Nombre"
        />
        <input
          type="text"
          name="direccion"
          value={state.direccion}
          onChange={handleChange}
          placeholder="Direccion"
        />
        <input
          type="text"
          name="telefono"
          value={state.telefono}
          onChange={handleChange}
          placeholder="Telefono"
        />
        <input
          type="email"
          name="email"
          value={state.email}
          onChange={handleChange}
          placeholder="Correo"
        />
        <input
          type="password"
          name="password"
          value={state.password}
          onChange={handleChange}
          placeholder="Contraseña"
        />
        <button type="submit">Registrarse</button>
      </form>
    </div>
  );
}

export default SignUpForm;