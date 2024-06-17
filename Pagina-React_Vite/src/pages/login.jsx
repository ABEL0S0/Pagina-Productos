import { useState } from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { Home } from "./Home.jsx";
import "./styles/login.css";
import SignUpForm from "../components/SignUpForm.jsx"
import SignInForm from "../components/SignInForm.jsx"

export default function Login() {
    const [type, setType] = useState("signIn");
  
    const handleOnClick = (text) => {
      if (text !== type) {
        setType(text);
      }
    };
  
    const handleLogin = (username) => {
      console.log(`User logged in: ${username}`);
      // Aquí puedes manejar la lógica de lo que sucede después del inicio de sesión
    };
  
    const containerClass = "container " + (type === "signUp" ? "right-panel-active" : "");
  
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
                        <p>Para mantenerse conectado con nosotros, inicie sesión con su información personal</p>
                        <button className="ghost" id="signIn" onClick={() => handleOnClick("signIn")}>
                          Iniciar Sesion
                        </button>
                        <Link to="/home/carrito">Ir al Carrito</Link> {/* Asegúrate de que el enlace apunte a /home/carrito */}
                      </div>
                      <div className="overlay-panel overlay-right">
                        <h1>Registrarse aqui</h1>
                        <p>Introduce tus datos personales y comienza tu viaje con nosotros.</p>
                        <button className="ghost" id="signUp" onClick={() => handleOnClick("signUp")}>
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