import { useState } from "react";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import '../styles.css';
import SignInForm from "./SignIn";
import SignUpForm from "./SignUp";
import Home from "../pages/Home";

export default function App() {
  const [type, setType] = useState("signIn");

  const handleOnClick = (text) => {
    if (text !== type) {
      setType(text);
      return;
    }
  };

  const handleLogin = (username) => {
    console.log(`User logged in: ${username}`);
    // Aquí puedes manejar la lógica de lo que sucede después del inicio de sesión
  };

  const containerClass =
    "container " + (type === "signUp" ? "right-panel-active" : "");

  return (
    <Router>
      <Routes>
        <Route path="/home/*" element={<Home />} />
        <Route 
          path="/" 
          element={
            <div className="App">
              <div className={containerClass} id="container">
                <SignUpForm />
                <SignInForm onLogin={handleLogin} />
                <div className="overlay-container">
                  <div className="overlay">
                    <div className="overlay-panel overlay-left">
                      <h1>Iniciar Sesion</h1>
                      <p>
                        Para mantenerse conectado con nosotros, inicie sesión con su información personal
                      </p>
                      <button
                        className="ghost"
                        id="signIn"
                        onClick={() => handleOnClick("signIn")}
                      >
                        Iniciar Sesion
                      </button>
                    </div>
                    <div className="overlay-panel overlay-right">
                      <h1>Registrarse aqui</h1>
                      <p>Introduce tus datos personales y comienza tu viaje con nosotros.</p>
                      <button
                        className="ghost"
                        id="signUp"
                        onClick={() => handleOnClick("signUp")}
                      >
                        Registrarse
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          } 
        />
      </Routes>
    </Router>
  );
}
