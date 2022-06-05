export const state = () => ({
  showModal: false,
  id: null,
  products: [
      {
        id: 1568585,
        name: "Shakar",
        price: 50000,
        measure: "2 qop",
      deadline: 2,
      status: "pending",
        date: "2020-05-01",
    },
     {
        id: 1568586,
        name: "Un",
        price: 50000,
        measure: "5 qop",
      deadline: 2,
      status: "pending",
        date: "2020-05-02",
    },
     {
        id: 1568587,
        name: "Go'sht",
        price: 50000,
        measure: "10 kg",
      deadline: 2,
      status: "pending",
        date: "2020-05-03",
    },
        {
        id: 1568588,
        name: "Pomidor",
        price: 50000,
        measure: "2 tonna",
      deadline: 2,
      status: "pending",
        date: "2020-05-01",
    },
    
  ],
  companies: [
    {
      id: 1,
      name: "Yunusobod Store",
      address: "Yunusobod, Tashkent",
    },
    {
      id: 2,
      name: "Mirzo Ulug'bek Store",
      address: "Chilonzor, Tashkent",
    },
    {
      id: 3,
      name: " ColdMax MCHJ",
      address: "Yunusobod, Tashkent",
    }
  ],
})

export const mutations = {
  showModal(state) {
    state.showModal = true;
  },
  hideModal(state) {
    state.showModal = false;
  },
  addProduct(state, data) {
    state.products.push(data);
  }
}