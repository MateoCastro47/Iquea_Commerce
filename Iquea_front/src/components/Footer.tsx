import { MdChair } from 'react-icons/md';
import { FiMapPin, FiPhone, FiMail, FiInstagram, FiFacebook } from 'react-icons/fi';
import { FaPinterest } from 'react-icons/fa';
import './Footer.css';

export default function Footer() {
    return (
        <footer className="footer">
            <div className="footer__container">
                <div className="footer__brand">
                    <span className="footer__logo"><MdChair /> Iquea</span>
                    <p className="footer__tagline">Muebles con alma. Diseño con propósito.</p>
                </div>

                <div className="footer__links">
                    <h4>Tienda</h4>
                    <a href="/productos">Catálogo</a>
                    <a href="/productos">Destacados</a>
                </div>

                <div className="footer__links">
                    <h4>Contacto</h4>
                    <p><FiMapPin /> Calle del Mueble 42, Madrid</p>
                    <p><FiPhone /> +34 910 000 000</p>
                    <p><FiMail /> hola@iquea.es</p>
                </div>

                <div className="footer__links">
                    <h4>Síguenos</h4>
                    <a href="https://instagram.com" target="_blank" rel="noreferrer">
                        <FiInstagram /> Instagram
                    </a>
                    <a href="https://pinterest.com" target="_blank" rel="noreferrer">
                        <FaPinterest /> Pinterest
                    </a>
                    <a href="https://facebook.com" target="_blank" rel="noreferrer">
                        <FiFacebook /> Facebook
                    </a>
                </div>
            </div>

            <div className="footer__bottom">
                <p>© {new Date().getFullYear()} Iquea. Todos los derechos reservados.</p>
            </div>
        </footer>
    );
}
