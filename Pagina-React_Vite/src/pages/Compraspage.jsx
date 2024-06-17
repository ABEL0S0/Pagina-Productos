import { Card } from "../components/Card";
import { useContext } from "react";
import { ProductContext } from "../Elements/ProductContext";
import { CarritoContext } from "../Elements/CarritoContext";

export const ComprasPage = () => {
  const productos = useContext(ProductContext);
  const { agregarCompra, eliminarCompra } = useContext(CarritoContext);

  const handleAgregar = (producto) => {
    agregarCompra({
      id: producto.id,
      nombre: producto.nombre,
      precio: producto.precio,
      cantidad: producto.stock || 1, // Usamos 1 como valor predeterminado si stock no está definido
    });
  };

  const handleQuitar = (id) => {
    eliminarCompra(id);
  };

  return (
    <div className="compras-container">
      {productos && productos.length > 0 ? (
        productos.map(product => (
          <Card
            key={product.id}
            nombre={product.nombre}
            image={product.id}
            descripcion={product.descripcion}
            precio={product.precio}
            stock={product.stock} // Asegúrate de pasar stock aquí si está disponible en productos
            handleAgregar={() => handleAgregar(product)}
            handleQuitar={() => handleQuitar(product.id)}
          />
        ))
      ) : (
        <p>No hay productos disponibles.</p>
      )}
    </div>
  );
};