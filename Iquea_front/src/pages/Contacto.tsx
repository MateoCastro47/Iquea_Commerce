import { useRef, useState } from 'react';
import { FiMapPin, FiPhone, FiMail } from 'react-icons/fi';
import './Contacto.css';

export default function Contacto() {
    const formRef = useRef<HTMLFormElement>(null);
    const [status, setStatus] = useState<'idle' | 'success' | 'error'>('idle');

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        // Simulate form submission
        setStatus('success');
        if (formRef.current) formRef.current.reset();
        setTimeout(() => setStatus('idle'), 3000);
    };

    return (
        <div className="contacto-page">
            <header className="contacto-header">
                <h1>Contáctanos</h1>
                <p>Estamos aquí para ayudarte. Envíanos un mensaje o visítanos.</p>
            </header>

            <div className="contacto-container">
                <div className="contacto-grid">
                    {/* Info Column */}
                    <div className="contacto-info">
                        <h2>Información de Contacto</h2>
                        <div className="contacto-item">
                            <FiMapPin className="contacto-icon" />
                            <div>
                                <h3>Dirección</h3>
                                <p>Calle del Mueble 42,<br />Madrid, 28001, España</p>
                            </div>
                        </div>
                        <div className="contacto-item">
                            <FiPhone className="contacto-icon" />
                            <div>
                                <h3>Teléfono</h3>
                                <p>+34 912 345 678</p>
                            </div>
                        </div>
                        <div className="contacto-item">
                            <FiMail className="contacto-icon" />
                            <div>
                                <h3>Email</h3>
                                <p>hola@iquea.es</p>
                            </div>
                        </div>

                        <div className="contacto-map">
                            <iframe
                                title="Mapa Iquea"
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3037.4!2d-3.7038!3d40.4168!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd422997800a3c81%3A0xc436dec1618c2269!2sMadrid%2C%20Spain!5e0!3m2!1sen!2ses!4v1700000000000"
                                width="100%"
                                height="250"
                                style={{ border: 0, borderRadius: '8px' }}
                                allowFullScreen
                                loading="lazy"
                            ></iframe>
                        </div>
                    </div>

                    {/* Form Column */}
                    <div className="contacto-form-wrap">
                        <h2>Envíanos un mensaje</h2>
                        <form ref={formRef} onSubmit={handleSubmit} className="contacto-form">
                            <div className="form-group">
                                <label htmlFor="name">Nombre</label>
                                <input type="text" id="name" required placeholder="Tu nombre" />
                            </div>
                            <div className="form-group">
                                <label htmlFor="email">Email</label>
                                <input type="email" id="email" required placeholder="tucorreo@ejemplo.com" />
                            </div>
                            <div className="form-group">
                                <label htmlFor="subject">Asunto</label>
                                <input type="text" id="subject" required placeholder="¿En qué podemos ayudarte?" />
                            </div>
                            <div className="form-group">
                                <label htmlFor="message">Mensaje</label>
                                <textarea id="message" rows={5} required placeholder="Escribe tu mensaje aquí..."></textarea>
                            </div>

                            <button type="submit" className="contacto-btn">
                                Enviar Mensaje
                            </button>

                            {status === 'success' && (
                                <p className="form-success">¡Mensaje enviado correctamente! Nos pondremos en contacto pronto.</p>
                            )}
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}
