import { useState, useEffect } from 'react';
import axios from 'axios';

const ProductList = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const response = await axios.get('http://localhost:8080/producto/list');
                setProducts(response.data);
            } catch (error) {
                console.error('Error fetching data: ', error);
            }
        };

        fetchProducts();
    }, []);

    const handleDelete = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/producto/delete/${id}`);
            setProducts(products.filter(product => product.id !== id));
        } catch (error) {
            console.error('Error deleting product: ', error);
        }
    };

    return (
        <div className="containerpl">
            <h2>Lista de Productos</h2>
            {products.map(product => (
                <div key={product.id} className="product-item">
                    <img src={`http://localhost:8080/producto/${product.id}/imagen`} alt={product.nombre} className="product-image" />
                    <div className="product-details">
                        <h3>{product.nombre}</h3>
                        <p>{product.descripcion}</p>
                        <p>Precio: {product.precio}</p>
                        <p>Categoría: {product.id_categoria}</p>
                        <p>Stock: {product.stock}</p>
                        <button onClick={() => handleDelete(product.id)}>Eliminar</button>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default ProductList;
