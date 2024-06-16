import { Card } from "../components/Card";
import { useContext} from "react";
import { ProductContext } from "../Context/ProductContext";
import { CarritoContext } from "../Context/CarritoContext";

export const ComprasPage = () => {
  const productos = useContext(ProductContext);
  const { agregarCompra, eliminarCompra } = useContext(CarritoContext);

  const handleAgregar = (compra) => {
    agregarCompra(compra);
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
            descripcion={product.descripcion}
            precio={product.precio}
            handleAgregar={() => handleAgregar(product.id)}
            handleQuitar={() => handleQuitar(product.id)}
          />
        ))
      ) : (
        <p>No hay productos disponibles.</p>
      )}
    </div>
  );
};
