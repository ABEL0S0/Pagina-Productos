import PropTypes from 'prop-types';
import { useEffect, useState } from "react";
import { ProductContext } from "./ProductContext";

export const ProductsProvider = ({ children }) => {
  const [productos, setProductos] = useState([]);

  const fetchProductos = async () => {
    const response = await fetch("http://localhost:8080/producto/list");
    const data = await response.json();
    console.log(data);
    setProductos(data);
  };

  useEffect(() => {
    fetchProductos();
  }, []);

  return (
    <ProductContext.Provider value={productos}>
      {children}
    </ProductContext.Provider>
  );
};

ProductsProvider.propTypes = {
  children: PropTypes.node.isRequired,
};
