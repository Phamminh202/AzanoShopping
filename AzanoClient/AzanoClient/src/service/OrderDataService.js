import http from "../http-common";
class OrderDataService {
    getAllBy(page,limit) {
        return http.get(`/admin/orders?page=${page}&limit=${limit}`);
    }
    getAllByName(page,limit,nameUser,orderId,phone,start, end) {
        return http.get(`/admin/orders?page=${page}&limit=${limit}&nameUser=${nameUser}&orderId=${orderId}&phone=${phone}&start=${start}&end=${end}`);
    }
    addCart(data) {
        return http.post(`/add-to-cart?userId=98dd4083-a416-4bec-b646-e6b1135bdc8c`, data);
    }
    checkout(data) {
        return http.post(`/add-to-cart`, data);
    }
}
export default new OrderDataService();
