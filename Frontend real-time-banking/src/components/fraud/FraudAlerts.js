import React, { useEffect, useState } from "react";
import API from "../../services/api";

const FraudAlerts = () => {
    const [alerts, setAlerts] = useState([]);

    useEffect(() => {
        const fetchAlerts = async () => {
            try {
                const { data } = await API.get("/fraud/alerts");
                setAlerts(data);
            } catch (err) {
                console.error("Error fetching fraud alerts:", err);
            }
        };

        fetchAlerts();
    }, []);

    return (
        <div>
            <h3>Fraud Alerts</h3>      
            <ul>
                {alerts.map((alert) => (
                    <li key={alert.id}>
                        Transaction {alert.transactionId} flagged for {alert.reason}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default FraudAlerts;
  