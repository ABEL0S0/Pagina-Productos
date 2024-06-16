import PropTypes from 'prop-types';
import "../pages/styles/Card.css";
import { useState } from "react";

export const Card = ({
  nombre,
  descripcion,
  precio,
  handleAgregar,
  handleQuitar,
  handleAumentar,
  handleDisminuir,
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
      <div className="tarjeta-contenido">
        <h3 className="tarjeta-titulo">{nombre}</h3>
        <p className="tarjeta-descripcion">{descripcion}</p>
        <p className="tarjeta-precio">{precio}</p>

        {added ? (
          <button type="button" className="boton-quitar" onClick={clickQuitar}>
            Quitar del Carrito
          </button>
        ) : (
          <button
            type="button"
            className="boton-agregar"
            onClick={clickAgregar}
          >
            Agregar Carrito
          </button>
        )}
      </div>
    </div>
  );
};

// Define prop types
Card.propTypes = {
  nombre: PropTypes.string.isRequired,
  descripcion: PropTypes.string.isRequired,
  precio: PropTypes.number.isRequired,
  handleAgregar: PropTypes.func.isRequired,
  handleQuitar: PropTypes.func.isRequired,
  handleAumentar: PropTypes.func, // Optional, adjust according to your needs
  handleDisminuir: PropTypes.func, // Optional, adjust according to your needs
};
