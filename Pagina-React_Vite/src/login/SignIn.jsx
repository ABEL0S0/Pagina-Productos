import { useState } from 'react';
import axios from 'axios';
import PropTypes from 'prop-types';
import { useNavigate } from 'react-router-dom';

const SignInForm = ({ onLogin }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate(); // Hook de useNavigate para redirigir

  const handleLogin = async (e) => {
    e.preventDefault();
    setError('');

    try {
      const response = await axios.get('http://localhost:8080/usuario/list');
      const usuarios = response.data;

      const user = usuarios.find(
        (u) => u.correo === email && u.contrasena === password
      );

      if (user) {
        onLogin(email);
        navigate('/home'); // Redirigir a la página Home
      } else {
        setError('Usuario o contraseña incorrectos');
      }
    } catch (error) {
      console.error('Error during login:', error);
      setError('Error al iniciar sesión');
    }
  };

  return (
    <div className="form-container sign-in-container">
      <form onSubmit={handleLogin}>
        <h1>Iniciar</h1>
        <input
          type="email"
          placeholder="Correo"
          name="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          name="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <p/>
        <button type="submit">Iniciar Sesion</button>
        {error && <p style={{ color: 'red' }}>{error}</p>}
      </form>
    </div>
  );
};

SignInForm.propTypes = {
  onLogin: PropTypes.func.isRequired,
};

export default SignInForm;
