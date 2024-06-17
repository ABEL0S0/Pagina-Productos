import PropTypes from 'prop-types';
import { useReducer } from "react";
import { CarritoContext } from "./CarritoContext";

const initialState = [];

const comprasReducer = (state = initialState, action) => {
  let existingProduct;
  switch (action.type) {
    case "[CARRITO] Agregar Compra":
      existingProduct = state.find(item => item.id === action.payload.id);
      if (existingProduct) {
        return state.map(item =>
          item.id === action.payload.id
           ? {...item, cantidad: item.cantidad + 1 }
            : item
        );
      }
      // If the product doesn't exist, add it with quantity 1
      return [...state, {...action.payload, cantidad: 1 }];
    case "[CARRITO] Aumentar Cantidad Compra":
      return state.map(item =>
        item.id === action.payload
          ? { ...item, cantidad: item.cantidad + 1 }
          : item
      );
    case "[CARRITO] Disminuir Cantidad Compra":
      return state.map(item =>
        item.id === action.payload && item.cantidad > 1
          ? { ...item, cantidad: item.cantidad - 1 }
          : item
      );
    case "[CARRITO] Eliminar Compra":
      return state.filter(compra => compra.id !== action.payload);
    default:
      return state;
  }
};

export const CarritoProvider = ({ children }) => {
  const [listaCompras, dispatch] = useReducer(comprasReducer, initialState);

  const agregarCompra = (compra) => {
    dispatch({
      type: "[CARRITO] Agregar Compra",
      payload: compra,
    });
  };
  const aumentarCantidad = (id) => {
    dispatch({
      type: "[CARRITO] Aumentar Cantidad Compra",
      payload: id,
    });
  };
  const disminuirCantidad = (id) => {
    dispatch({
      type: "[CARRITO] Disminuir Cantidad Compra",
      payload: id,
    });
  };
  const eliminarCompra = (id) => {
    dispatch({
      type: "[CARRITO] Eliminar Compra",
      payload: id,
    });
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
