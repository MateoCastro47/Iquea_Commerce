import { useState } from 'react';
import { MdChair } from 'react-icons/md';
import { FiMapPin, FiPhone, FiMail, FiInstagram, FiFacebook, FiArrowRight } from 'react-icons/fi';
import { FaPinterest } from 'react-icons/fa';
import './Footer.css';

export default function Footer() {
    const [email, setEmail] = useState('');

    return (
        <footer className="footer">
            <div className="footer__container footer__grid">
                {/* Brand */}
                <div className="footer__brand">
                    <span className="footer__logo"><MdChair /> Iquea</span>
                    <p className="footer__tagline">
                        Inspirando hogares con diseño elegante. Muebles modernos para la vida contemporánea.
                    </p>
                    <div className="footer__socials">
                        <a href="https://instagram.com" target="_blank" rel="noreferrer"><FiInstagram /></a>
                        <a href="https://facebook.com" target="_blank" rel="noreferrer"><FiFacebook /></a>
                        <a href="https://pinterest.com" target="_blank" rel="noreferrer"><FaPinterest /></a>
                    </div>
                </div>

                {/* Links */}
                <div className="footer__col">
                    <h4 className="footer__col-title">Tienda</h4>
                    <a href="/productos">Salón</a>
                    <a href="/productos">Dormitorio</a>
                    <a href="/productos">Oficina</a>
                    <a href="/productos">Jardín</a>
                </div>

                <div className="footer__col">
                    <h4 className="footer__col-title">Soporte</h4>
                    <a href="/contacto">Contacto</a>
                    <a href="/faq">FAQs</a>
                    <a href="/envios">Envíos y Devoluciones</a>
                    <a href="/privacidad">Política de Privacidad</a>
                </div>

                {/* Newsletter */}
                <div className="footer__col footer__newsletter">
                    <h4 className="footer__col-title">Newsletter</h4>
                    <p>Suscríbete para recibir actualizaciones, acceso a descuentos exclusivos y más.</p>
                    <form
                        className="footer__newsletter-form"
                        onSubmit={(e) => { e.preventDefault(); setEmail(''); }}
                    >
                        <input
                            type="email"
                            placeholder="Tu email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            className="footer__newsletter-input"
                            required
                        />
                        <button type="submit" className="footer__newsletter-btn">
                            <FiArrowRight />
                        </button>
                    </form>
                </div>
            </div>

            {/* Bottom */}
            <div className="footer__bottom">
                <div className="footer__container footer__bottom-inner">
                    <p>© {new Date().getFullYear()} Iquea. Todos los derechos reservados.</p>
                    <div className="footer__contact">
                        <span><FiMapPin /> Calle del Mueble 42, Madrid</span>
                        <span><FiPhone /> +34 910 000 000</span>
                        <span><FiMail /> hola@iquea.es</span>
                    </div>
                </div>
            </div>
        </footer>
    );
}
