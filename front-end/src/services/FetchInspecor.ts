import axios from 'axios';
import { AxiosResponse } from 'axios';

const service = axios.create({
    baseURL: "http://127.0.0.1:8080",
    timeout: 120000,
});



service.interceptors.response.use(
    (response: { data: AxiosResponse<any> }) => {
        return response.data;
    },
    (error: { response?: { status?: number; message?: string } }) => {
        const notificationParam: any = {
            message: '',
        };

        if (error.response?.status === 404) {
            notificationParam.message = 'Not Found';
        }

        if (error.response?.status === 500) {
            notificationParam.message = 'Internal Server Error';
        }

        if (error.response?.status === 508) {
            notificationParam.message = 'Time Out';
        }

        // notification.error(notificationParam);

        return Promise.reject(error);
    },
);

export default service;
