import express from 'express';
import router from './routes';
import { initializeDatabase } from "./models/db";

const app = express();
const port = 4001;

app.use(express.json());
app.use(router);

initializeDatabase().then(() => { // initialize database before starting the server
    app.listen(port, () => {
        console.log(`Server is running on port ${port}`);
    });
});
