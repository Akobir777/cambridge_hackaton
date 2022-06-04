<template>
  <div>
    <div class="bg-white shadow">
      <div class="px-4 sm:px-6 lg:max-w-6xl lg:mx-auto lg:px-8">
        <div
          class="py-6 md:flex md:items-center md:justify-between lg:border-t lg:border-gray-200"
        >
          <div class="flex-1 min-w-0">
            <!-- Profile -->
            <div class="flex items-center">
              <img
                class="hidden h-16 w-16 rounded-full sm:block"
                src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAyVBMVEX71DP///8UFRgAABb/2DT/2jT/2zT70yoQEhj70h4AABX70RENEBj70y370iX70iAFCxfwyzL833X+8cb955r71TjRsS3/+ur71j/++OP72lj84Hr+8MH84X///vr1zzLkwTA7NBvmwjDcui/+89D+9tqBbiNxYSGylynCpCuzmCn844n72En96KD83GVDOxwmIxn966z955seHRlaTh6jiidQRh1LQR1kVh8uKhojIRmLdyRvXyF8aiKHcySojyj97bWXgSXIqixp0xLoAAAPnUlEQVR4nN2d6ULqOheGW5K2hNIBZBIZVNAtgqjHCba6He7/or60QBnapJkK5XvPn31+VPOYZA3JSqLpmavXHHYea+PptD1ptepavd6atKfVce2xMzztZf/rtSx/ePPkrtuuezbyXMtyHEdbCf/bslwPIVRvn911TrNsRFaEzZPaFKO51horWU5AarfHnWZGLcmCsNnpthBy09i2ORFqdTOhVE44HE9sL7Xnkik9ezIeqm6QUsLeyZmLhOgiShe5Zycq26SSMMSToFvJQlZXYU+qIjwdq8GLIGuqDKwawk7bdpXhLeTa046StikgbNY8JDP3SHKQV1NgXKUJT8+Q6u5by/W60oyShFdTW93sS5Jln0lOSClCzJfF8NxhRFUpRgnCZnUPfCGjfSYxVoUJe+OMx+cWI6oJZyGihI9udvYlSa4j6jvECK8maK98gVBbbDoKEY73NAG35aDangiHzn4H6FpeXSBe5SbsdQ/SgQs59jhzwsN14EJu6ypbwtoBO3Ahx77LkLDX3r8JjQtNuXwjD+HQ2p+Pp8nSeEYqB+GdfWi0lRz7MQvCah5G6EroTDlhb3JYG7ort806GRkJT6VW0LKQVWfMN9gIh5ksU8jJ8dgCHCbCx9zYmC3ZTAurLIQ5BcSILBkVA2F+vERMLF4jnfC//AIyIaYS5hqQBTGNMMdDdKFUxBTC3BqZtexvGcLv/AOmOg0q4ckxAGJEaqpBI7zKU6xNk0cL4CiETa6d+EPKqVPCcArh5FgAcRjeFiGc5itdossl54tEwtqxTMKFENEtkgiPxIyuRTSoBMLmcfWgFhSSEawNgfCIrMxK1pSHsOYdur0CQslLxYmEw2ObhAslT8Ukwp5z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"
                alt=""
              />
              <div>
                <div class="flex items-center">
                  <img
                    class="h-16 w-16 rounded-full sm:hidden"
                    src="https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2.6&w=256&h=256&q=80"
                    alt=""
                  />
                  <h1
                    class="ml-3 text-2xl font-bold leading-7 text-gray-900 sm:leading-9 sm:truncate"
                  >
                    Assalomu Aleykum , Legion
                  </h1>
                </div>
                <dl
                  class="mt-6 flex flex-col sm:ml-3 sm:mt-1 sm:flex-row sm:flex-wrap"
                >
                  <dt class="sr-only">Company</dt>
                  <dd
                    class="flex items-center text-sm text-gray-500 font-medium capitalize sm:mr-6"
                  >
                    <!-- Heroicon name: solid/office-building -->
                    <svg
                      class="flex-shrink-0 mr-1.5 h-5 w-5 text-gray-400"
                      xmlns="http://www.w3.org/2000/svg"
                      viewBox="0 0 20 20"
                      fill="currentColor"
                      aria-hidden="true"
                    >
                      <path
                        fill-rule="evenodd"
                        d="M4 4a2 2 0 012-2h8a2 2 0 012 2v12a1 1 0 110 2h-3a1 1 0 01-1-1v-2a1 1 0 00-1-1H9a1 1 0 00-1 1v2a1 1 0 01-1 1H4a1 1 0 110-2V4zm3 1h2v2H7V5zm2 4H7v2h2V9zm2-4h2v2h-2V5zm2 4h-2v2h2V9z"
                        clip-rule="evenodd"
                      />
                    </svg>
                    Coca Cola
                  </dd>
                </dl>
              </div>
            </div>
          </div>
          <div class="mt-6 flex space-x-3 md:mt-0 md:ml-4">
            <button
              type="button"
              class="inline-flex items-center px-4 py-2 border border-gray-300 shadow-sm text-sm font-medium rounded-md text-gray-700 bg-white hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-cyan-500"
            >
              Add money
            </button>
            <button
              type="button"
              class="inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-cyan-600 hover:bg-cyan-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-cyan-500"
            >
              Send money
            </button>
          </div>
        </div>
      </div>
    </div>

    <div class="mt-8">
      <div class="max-w-6xl mx-auto px-4 sm:px-6 lg:px-8">
        <h2 class="text-lg leading-6 font-medium text-gray-900">Overview</h2>
        <div class="mt-2 grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
          <!-- Card -->

          <div class="bg-white overflow-hidden shadow rounded-lg">
            <div class="p-5">
              <div class="flex items-center">
                <div class="flex-shrink-0">
                  <!-- Heroicon name: outline/scale -->
                  <svg
                    class="h-6 w-6 text-gray-400"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    aria-hidden="true"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M3 6l3 1m0 0l-3 9a5.002 5.002 0 006.001 0M6 7l3 9M6 7l6-2m6 2l3-1m-3 1l-3 9a5.002 5.002 0 006.001 0M18 7l3 9m-3-9l-6-2m0-2v2m0 16V5m0 16H9m3 0h3"
                    />
                  </svg>
                </div>
                <div class="ml-5 w-0 flex-1">
                  <dl>
                    <dt class="text-sm font-medium text-gray-500 truncate">
                      Account balance
                    </dt>
                    <dd>
                      <div class="text-lg font-medium text-gray-900">
                        $30,659.45
                      </div>
                    </dd>
                  </dl>
                </div>
              </div>
            </div>
            <div class="bg-gray-50 px-5 py-3">
              <div class="text-sm">
                <a
                  href="#"
                  class="font-medium text-cyan-700 hover:text-cyan-900"
                >
                  View all
                </a>
              </div>
            </div>
          </div>

          <!-- More items... -->
        </div>
      </div>

      <h2
        class="max-w-6xl mx-auto mt-8 px-4 text-lg leading-6 font-medium text-gray-900 sm:px-6 lg:px-8"
      >
        Recent activity
      </h2>

      <!-- Activity list (smallest breakpoint only) -->
      <div class="shadow sm:hidden">
        <ul
          class="mt-2 divide-y divide-gray-200 overflow-hidden shadow sm:hidden"
        >
          <li>
            <a href="#" class="block px-4 py-4 bg-white hover:bg-gray-50">
              <span class="flex items-center space-x-4">
                <span class="flex-1 flex space-x-2 truncate">
                  <!-- Heroicon name: solid/cash -->
                  <svg
                    class="flex-shrink-0 h-5 w-5 text-gray-400"
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                  >
                    <path
                      fill-rule="evenodd"
                      d="M4 4a2 2 0 00-2 2v4a2 2 0 002 2V6h10a2 2 0 00-2-2H4zm2 6a2 2 0 012-2h8a2 2 0 012 2v4a2 2 0 01-2 2H8a2 2 0 01-2-2v-4zm6 4a2 2 0 100-4 2 2 0 000 4z"
                      clip-rule="evenodd"
                    />
                  </svg>
                  <span class="flex flex-col text-gray-500 text-sm truncate">
                    <span class="truncate">Payment to Molly Sanders</span>
                    <span
                      ><span class="text-gray-900 font-medium">$20,000</span>
                      USD</span
                    >
                    <time datetime="2020-07-11">July 11, 2020</time>
                  </span>
                </span>
                <!-- Heroicon name: solid/chevron-right -->
                <svg
                  class="flex-shrink-0 h-5 w-5 text-gray-400"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 20 20"
                  fill="currentColor"
                  aria-hidden="true"
                >
                  <path
                    fill-rule="evenodd"
                    d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                    clip-rule="evenodd"
                  />
                </svg>
              </span>
            </a>
          </li>

          <!-- More transactions... -->
        </ul>

        <nav
          class="bg-white px-4 py-3 flex items-center justify-between border-t border-gray-200"
          aria-label="Pagination"
        >
          <div class="flex-1 flex justify-between">
            <a
              href="#"
              class="relative inline-flex items-center px-4 py-2 border border-gray-300 text-sm font-medium rounded-md text-gray-700 bg-white hover:text-gray-500"
            >
              Previous
            </a>
            <a
              href="#"
              class="ml-3 relative inline-flex items-center px-4 py-2 border border-gray-300 text-sm font-medium rounded-md text-gray-700 bg-white hover:text-gray-500"
            >
              Next
            </a>
          </div>
        </nav>
      </div>

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
                      Transaction
                    </th>
                    <th
                      class="px-6 py-3 bg-gray-50 text-right text-xs font-medium text-gray-500 uppercase tracking-wider"
                    >
                      Amount
                    </th>
                    <th
                      class="hidden px-6 py-3 bg-gray-50 text-left text-xs font-medium text-gray-500 uppercase tracking-wider md:block"
                    >
                      Status
                    </th>
                    <th
                      class="px-6 py-3 bg-gray-50 text-right text-xs font-medium text-gray-500 uppercase tracking-wider"
                    >
                      Date
                    </th>
                  </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                  <tr class="bg-white">
                    <td
                      class="max-w-0 w-full px-6 py-4 whitespace-nowrap text-sm text-gray-900"
                    >
                      <div class="flex">
                        <a
                          href="#"
                          class="group inline-flex space-x-2 truncate text-sm"
                        >
                          <!-- Heroicon name: solid/cash -->
                          <svg
                            class="flex-shrink-0 h-5 w-5 text-gray-400 group-hover:text-gray-500"
                            xmlns="http://www.w3.org/2000/svg"
                            viewBox="0 0 20 20"
                            fill="currentColor"
                            aria-hidden="true"
                          >
                            <path
                              fill-rule="evenodd"
                              d="M4 4a2 2 0 00-2 2v4a2 2 0 002 2V6h10a2 2 0 00-2-2H4zm2 6a2 2 0 012-2h8a2 2 0 012 2v4a2 2 0 01-2 2H8a2 2 0 01-2-2v-4zm6 4a2 2 0 100-4 2 2 0 000 4z"
                              clip-rule="evenodd"
                            />
                          </svg>
                          <p
                            class="text-gray-500 truncate group-hover:text-gray-900"
                          >
                            Payment to Molly Sanders
                          </p>
                        </a>
                      </div>
                    </td>
                    <td
                      class="px-6 py-4 text-right whitespace-nowrap text-sm text-gray-500"
                    >
                      <span class="text-gray-900 font-medium">$20,000 </span>
                      USD
                    </td>
                    <td
                      class="hidden px-6 py-4 whitespace-nowrap text-sm text-gray-500 md:block"
                    >
                      <span
                        class="inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium bg-green-100 text-green-800 capitalize"
                      >
                        success
                      </span>
                    </td>
                    <td
                      class="px-6 py-4 text-right whitespace-nowrap text-sm text-gray-500"
                    >
                      <time datetime="2020-07-11">July 11, 2020</time>
                    </td>
                  </tr>

                  <!-- More transactions... -->
                </tbody>
              </table>
              <!-- Pagination -->
              <nav
                class="bg-white px-4 py-3 flex items-center justify-between border-t border-gray-200 sm:px-6"
                aria-label="Pagination"
              >
                <div class="hidden sm:block">
                  <p class="text-sm text-gray-700">
                    Showing
                    <span class="font-medium">1</span>
                    to
                    <span class="font-medium">10</span>
                    of
                    <span class="font-medium">20</span>
                    results
                  </p>
                </div>
                <div class="flex-1 flex justify-between sm:justify-end">
                  <a
                    href="#"
                    class="relative inline-flex items-center px-4 py-2 border border-gray-300 text-sm font-medium rounded-md text-gray-700 bg-white hover:bg-gray-50"
                  >
                    Previous
                  </a>
                  <a
                    href="#"
                    class="ml-3 relative inline-flex items-center px-4 py-2 border border-gray-300 text-sm font-medium rounded-md text-gray-700 bg-white hover:bg-gray-50"
                  >
                    Next
                  </a>
                </div>
              </nav>
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
};
</script>
