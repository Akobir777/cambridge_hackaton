<template>
  <div>
    <div class="mt-8">
      <h2
        class="max-w-6xl mx-auto mt-8 px-4 text-lg leading-6 font-medium text-gray-900 sm:px-6 lg:px-8"
      >
        Qaytarishga Jo'natilgan Buyurtmalar
      </h2>

      <!-- Activity table (small breakpoint and up) -->
      <div class="hidden sm:block">
        <div class="max-w-6xl mx-auto px-4 sm:px-6 lg:px-8">
          <div class="flex flex-col mt-2">
            <div
              class="align-middle min-w-full overflow-x-auto shadow overflow-hidden sm:rounded-lg"
            >
              <table class="min-w-full divide-y divide-gray-200">
                <thead>
                  <tr>
                    <th
                      class="px-6 py-3 bg-gray-50 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                    >
                      Nomi
                    </th>
                    <th
                      class="px-6 py-3 text-left bg-gray-50 text-xs font-medium text-gray-500 uppercase tracking-wider"
                    >
                      ID
                    </th>
                    <th
                      class="px-6 py-3 text-left bg-gray-50 text-xs font-medium text-gray-500 uppercase tracking-wider"
                    >
                      Miqdori
                    </th>
                    <th
                      class="px-6 py-3 text-left bg-gray-50 text-xs font-medium text-gray-500 uppercase tracking-wider"
                    >
                      Muddati
                    </th>
                    <th
                      class="px-6 py-3 text-left bg-gray-50 text-xs font-medium text-gray-500 uppercase tracking-wider"
                    >
                      Narxi
                    </th>
                    <th
                      class="hidden px-6 py-3 text-left bg-gray-50 text-xs font-medium text-gray-500 uppercase tracking-wider md:block"
                    >
                      Status
                    </th>
                    <th
                      class="px-6 py-3 text-left bg-gray-50 text-xs font-medium text-gray-500 uppercase tracking-wider"
                    >
                      Sana
                    </th>
                  </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                  <tr
                    class="bg-white"
                    v-for="(product, index) in this.products.slice().reverse()"
                    v-bind:key="index"
                  >
                    <td
                      class="max-w-0 w-full px-6 py-4 whitespace-nowrap text-sm text-gray-900"
                    >
                      {{ product.name }}
                    </td>
                    <td class="text-left">{{ product.id }}</td>
                    <td
                      class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"
                    >
                      {{ product.measure }}
                    </td>
                    <td
                      class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"
                    >
                      <span class="text-gray-900 font-medium"
                        >{{ product.deadline }}
                      </span>
                      kun
                    </td>
                    <td
                      class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"
                    >
                      <span class="text-gray-900 font-medium"
                        >{{ product.price }}
                      </span>
                      SO'M
                    </td>
                    <td
                      class="hidden px-6 py-4 whitespace-nowrap text-sm text-gray-500 md:block"
                    >
                      <span
                        class="inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium bg-gray-100 text-gray-800 capitalize"
                      >
                        tugallangan
                      </span>
                    </td>
                    <td
                      class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"
                    >
                      <time datetime="2020-07-11">{{ product.date }}</time>
                    </td>
                  </tr>

                  <!-- More transactions... -->
                </tbody>
              </table>
              <!-- Pagination -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "IndexPage",
  data() {
    return {
      products: [
        {
          id: 1545587,
          name: "Kompyuter",
          price: 50400,
          measure: "10 dona",
          deadline: 2,
          status: "pending",
          date: "2020-05-03",
        },
        {
          id: 1545588,
          name: "Kiyimlar",
          price: 5000000,
          measure: "100 kg",
          deadline: 2,
          status: "pending",
          date: "2020-05-01",
        },
        {
          id: 1545588,
          name: "Suv",
          price: 60000,
          measure: "1000 litr",
          deadline: 2,
          status: "pending",
          date: "2020-05-01",
        },
      ],
    };
  },
};
</script>
