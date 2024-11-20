import React, { useEffect, useState } from "react";
import API from "../../services/api";

const Transactions = () => {
    const [transactions, setTransactions] = useState([]);

    useEffect(() => {
        const fetchTransactions = async () => {
            try {
                const { data } = await API.get("/transactions/user/me");
                setTransactions(data);
            } catch (err) {
                console.error("Error fetching transactions:", err);
            }
        };

        fetchTransactions();
    }, []);

    return (
        <div>
            <h3>Your Transactions</h3>
            <ul>
                {transactions.map((transaction) => (
                    <li key={transaction.id}>
                        {transaction.amount} - {transaction.status}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Transactions;