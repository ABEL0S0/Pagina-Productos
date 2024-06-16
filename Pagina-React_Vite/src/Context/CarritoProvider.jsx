import PropTypes from 'prop-types';
import { useReducer } from "react";
import { CarritoContext } from "./CarritoContext";

const initialState = [];

export const CarritoProvider = ({ children }) => {
  const comprasReducer = (state = initialState, action = {}) => {
    switch (action.type) {
      case "[CARRITO] Agregar Compra":
        // Asegúrate de que action.payload sea un objeto válido con id, nombre, precio, cantidad, etc.
        action.payload.cantidad = 1; // Esto se podría manejar dentro del payload si es necesario
        return [...state, action.payload];
      case "[CARRITO] Aumentar Cantidad Compra":
        return state.map((item) => {
          if (item.id === action.payload && item.cantidad) {
            return { ...item, cantidad: item.cantidad + 1 };
          }
          return item;
        });
      case "[CARRITO] Disminuir Cantidad Compra":
        return state.map((item) => {
          if (item.id === action.payload && item.cantidad > 1) {
            return { ...item, cantidad: item.cantidad - 1 };
          }
          return item;
        });
      case "[CARRITO] Eliminar Compra":
        return state.filter((compra) => compra.id !== action.payload);
      default:
        return state;
    }
  };

  const [listaCompras, dispatch] = useReducer(comprasReducer, initialState);

  const agregarCompra = (compra) => {
    compra.cantidad = 1;
    const action = {
      type: "[CARRITO] Agregar Compra",
      payload: compra,
    };
    dispatch(action);
  };
  const aumentarCantidad = (id) => {
    const action = {
      type: "[CARRITO] Aumentar Cantidad Compra",
      payload: id,
    };
    dispatch(action);
  };
  const disminuirCantidad = (id) => {
    const action = {
      type: "[CARRITO] Disminuir Cantidad Compra",
      payload: id,
    };
    dispatch(action);
  };
  const eliminarCompra = (id) => {
    const action = {
      type: "[CARRITO] Eliminar Compra",
      payload: id,
    };
    dispatch(action);
  };

  return (
    <CarritoContext.Provider
      value={{
        listaCompras,
        agregarCompra,
        aumentarCantidad,
        disminuirCantidad,
        eliminarCompra,
      }}
    >
      {children}
    </CarritoContext.Provider>
  );
};

CarritoProvider.propTypes = {
  children: PropTypes.node.isRequired,
};
