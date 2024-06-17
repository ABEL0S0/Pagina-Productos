import PropTypes from 'prop-types';
import { useState } from "react";
import "./styles/Card.css"

export const Card = ({
    nombre,
    descripcion,
    precio,
    image,
    stock,
    handleAgregar,
    handleQuitar,
  }) => {
    const [added, setAdded] = useState(false);
  
    const clickAgregar = () => {
      handleAgregar();
      setAdded(true);
    };
  
    const clickQuitar = () => {
      handleQuitar();
      setAdded(false);
    };
  
    return (
      <div className="tarjeta">
        <img src={`http://localhost:8080/producto/${image}/imagen`} alt={nombre} className="tarjeta-imagen" />
        <div className="tarjeta-contenido">
          <h3 className="tarjeta-titulo">{nombre}</h3>
          <p className="tarjeta-descripcion">{descripcion}</p>
          <p className="tarjeta-precio">${precio}</p>
          {stock !== undefined && (
            <p className="tarjeta-stock">en Stock: {stock}</p>
          )}
  
          {added ? (
            <button type="button" className="boton-quitar" onClick={clickQuitar}>
              Quitar del Carrito
            </button>
          ) : (
            <button type="button" className="boton-agregar" onClick={clickAgregar}>
              Agregar al Carrito
            </button>
          )}
        </div>
      </div>
    );
  };
  
  Card.propTypes = {
    nombre: PropTypes.string.isRequired,
    descripcion: PropTypes.string.isRequired,
    precio: PropTypes.number.isRequired,
    image: PropTypes.number.isRequired,
    stock: PropTypes.number, // Cambiado a PropTypes.number opcional
    handleAgregar: PropTypes.func.isRequired,
    handleQuitar: PropTypes.func.isRequired,
  };
  
  export default Card;