import "./styles/adminproduct.css"
import axios from 'axios';
import  { useState, useEffect } from 'react';
import ProductForm from "../components/ProductForm";
import ProductList from "../components/ProductList";

export default function AdminProduct() {
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

    const handleProductAdded = (newProduct) => {
        setProducts([...products, newProduct]); // Agrega el nuevo producto a la lista de productos
    };

    return (
        <div className="App">
            <div className="container text-center">
            <div className="row align-items-center">
                <div className="col">
                <ProductList products={products} />
                </div>
                <div className="col">
                <ProductForm onProductAdded={handleProductAdded} />
                </div>
            </div>
            </div>
        </div>
    );
}
