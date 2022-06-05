<template>
  <!--
  This example requires Tailwind CSS v2.0+ 
  
  This example requires some changes to your config:
  
  ```
  // tailwind.config.js
  const colors = require('tailwindcss/colors')
  
  module.exports = {
    // ...
    theme: {
      extend: {
        colors: {
          cyan: colors.cyan,
        }
      }
    },
    plugins: [
      // ...
      require('@tailwindcss/forms'),
    ]
  }
  ```
-->
  <div class="relative h-screen flex overflow-hidden bg-gray-100">
    <!-- Off-canvas menu for mobile, show/hide based on off-canvas menu state. -->
    <div
      class="fixed inset-0 flex z-40 lg:hidden"
      role="dialog"
      aria-modal="true"
    >
      <!--
      Off-canvas menu overlay, show/hide based on off-canvas menu state.

      Entering: "transition-opacity ease-linear duration-300"
        From: "opacity-0"
        To: "opacity-100"
      Leaving: "transition-opacity ease-linear duration-300"
        From: "opacity-100"
        To: "opacity-0"
    -->
      <div
        class="fixed inset-0 bg-gray-600 bg-opacity-75"
        aria-hidden="true"
      ></div>

      <!--
      Off-canvas menu, show/hide based on off-canvas menu state.

      Entering: "transition ease-in-out duration-300 transform"
        From: "-translate-x-full"
        To: "translate-x-0"
      Leaving: "transition ease-in-out duration-300 transform"
        From: "translate-x-0"
        To: "-translate-x-full"
    -->
      <div
        class="relative flex-1 flex flex-col max-w-xs w-full pt-5 pb-4 bg-cyan-700"
      >
        <!--
        Close button, show/hide based on off-canvas menu state.

        Entering: "ease-in-out duration-300"
          From: "opacity-0"
          To: "opacity-100"
        Leaving: "ease-in-out duration-300"
          From: "opacity-100"
          To: "opacity-0"
      -->
        <div class="absolute top-0 right-0 -mr-12 pt-2">
          <button
            class="ml-1 flex items-center justify-center h-10 w-10 rounded-full focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white"
          >
            <span class="sr-only">Close sidebar</span>
            <!-- Heroicon name: outline/x -->
            <svg
              class="h-6 w-6 text-white"
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
                d="M6 18L18 6M6 6l12 12"
              />
            </svg>
          </button>
        </div>

        <div class="flex-shrink-0 flex items-center px-4">
          <img
            class="h-8 w-auto"
            src="https://tailwindui.com/img/logos/easywire-logo-cyan-300-mark-white-text.svg"
            alt="Easywire logo"
          />
        </div>
      </div>

      <div class="flex-shrink-0 w-14" aria-hidden="true">
        <!-- Dummy element to force sidebar to shrink to fit close icon -->
      </div>
    </div>

    <!-- Static sidebar for desktop -->
    <div class="hidden lg:flex lg:flex-shrink-0">
      <div class="flex flex-col w-64">
        <!-- Sidebar component, swap this element with another sidebar if you like -->
        <div
          class="flex flex-col flex-grow bg-cyan-700 pt-5 pb-4 overflow-y-auto"
        >
          <div class="flex items-center flex-shrink-0 px-4">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="48"
              height="48"
              fill="currentColor"
              class="bi bi-boxes fill-cyan-200"
              viewBox="0 0 16 16"
            >
              <path
                d="M7.752.066a.5.5 0 0 1 .496 0l3.75 2.143a.5.5 0 0 1 .252.434v3.995l3.498 2A.5.5 0 0 1 16 9.07v4.286a.5.5 0 0 1-.252.434l-3.75 2.143a.5.5 0 0 1-.496 0l-3.502-2-3.502 2.001a.5.5 0 0 1-.496 0l-3.75-2.143A.5.5 0 0 1 0 13.357V9.071a.5.5 0 0 1 .252-.434L3.75 6.638V2.643a.5.5 0 0 1 .252-.434L7.752.066ZM4.25 7.504 1.508 9.071l2.742 1.567 2.742-1.567L4.25 7.504ZM7.5 9.933l-2.75 1.571v3.134l2.75-1.571V9.933Zm1 3.134 2.75 1.571v-3.134L8.5 9.933v3.134Zm.508-3.996 2.742 1.567 2.742-1.567-2.742-1.567-2.742 1.567Zm2.242-2.433V3.504L8.5 5.076V8.21l2.75-1.572ZM7.5 8.21V5.076L4.75 3.504v3.134L7.5 8.21ZM5.258 2.643 8 4.21l2.742-1.567L8 1.076 5.258 2.643ZM15 9.933l-2.75 1.571v3.134L15 13.067V9.933ZM3.75 14.638v-3.134L1 9.933v3.134l2.75 1.571Z"
              />
            </svg>
            <p class="text-2xl font-extrabold text-white ml-4">WareSmart</p>
          </div>
          <nav
            class="mt-5 flex-1 flex flex-col divide-y divide-cyan-800 overflow-y-auto"
            aria-label="Sidebar"
          >
            <div class="px-2 space-y-1">
              <!-- Current: "bg-cyan-800 text-white", Default: "text-cyan-100 hover:text-white hover:bg-cyan-600" -->
              <NuxtLink
                to="/"
                class="group flex items-center px-2 py-2 text-sm leading-6 font-medium rounded-md"
                aria-current="page"
                v-bind:class="`${
                  $nuxt.$route.name == 'index'
                    ? 'bg-cyan-800 text-white'
                    : 'text-cyan-100 hover:text-white hover:bg-cyan-600'
                }`"
              >
                <!-- Heroicon name: outline/home -->
                <svg
                  class="mr-4 flex-shrink-0 h-6 w-6 text-cyan-200"
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
                    d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"
                  />
                </svg>
                Buyurtma Berish
              </NuxtLink>

              <NuxtLink
                to="/unverified"
                class="group flex items-center px-2 py-2 text-sm leading-6 font-medium rounded-md"
                v-bind:class="`${
                  $nuxt.$route.name == 'unverified'
                    ? 'bg-cyan-800 text-white'
                    : 'text-cyan-100 hover:text-white hover:bg-cyan-600'
                }`"
              >
                <!-- Heroicon name: outline/clock -->
                <svg
                  class="mr-4 flex-shrink-0 h-6 w-6 text-cyan-200"
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
                    d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z"
                  />
                </svg>
                Kutishdagilar
              </NuxtLink>

              <NuxtLink
                to="/verified"
                class="group flex items-center px-2 py-2 text-sm leading-6 font-medium rounded-md"
                v-bind:class="`${
                  $nuxt.$route.name == 'verified'
                    ? 'bg-cyan-800 text-white'
                    : 'text-cyan-100 hover:text-white hover:bg-cyan-600'
                }`"
              >
                <!-- Heroicon name: outline/scale -->
                <svg
                  class="mr-4 flex-shrink-0 h-6 w-6 text-cyan-200"
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
                Tasdiqlanganlar
              </NuxtLink>

              <NuxtLink
                to="/storage"
                class="group flex items-center px-2 py-2 text-sm leading-6 font-medium rounded-md"
                v-bind:class="`${
                  $nuxt.$route.name == 'storage'
                    ? 'bg-cyan-800 text-white'
                    : 'text-cyan-100 hover:text-white hover:bg-cyan-600'
                }`"
              >
                <!-- Heroicon name: outline/credit-card -->
                <svg
                  class="mr-4 flex-shrink-0 h-6 w-6 text-cyan-200"
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
                    d="M3 10h18M7 15h1m4 0h1m-7 4h12a3 3 0 003-3V8a3 3 0 00-3-3H6a3 3 0 00-3 3v8a3 3 0 003 3z"
                  />
                </svg>
                Omborxonadagilar
              </NuxtLink>

              <NuxtLink
                to="/onroute"
                class="group flex items-center px-2 py-2 text-sm leading-6 font-medium rounded-md"
                v-bind:class="`${
                  $nuxt.$route.name == 'onroute'
                    ? 'bg-cyan-800 text-white'
                    : 'text-cyan-100 hover:text-white hover:bg-cyan-600'
                }`"
              >
                <!-- Heroicon name: outline/user-group -->
                <svg
                  class="mr-4 flex-shrink-0 h-6 w-6 text-cyan-200"
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
                    d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z"
                  />
                </svg>
                Qaytayotganlar
              </NuxtLink>
            </div>
            <div class="mt-6 pt-6">
              <div class="px-2 space-y-1">
                <NuxtLink
                  to="/measurements"
                  class="group flex items-center px-2 py-2 text-sm leading-6 font-medium rounded-md"
                  v-bind:class="`${
                    $nuxt.$route.name == 'measurements'
                      ? 'bg-cyan-800 text-white'
                      : 'text-cyan-100 hover:text-white hover:bg-cyan-600'
                  }`"
                >
                  <!-- Heroicon name: outline/cog -->
                  <svg
                    class="mr-4 h-6 w-6 text-cyan-200"
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
                      d="M10.325 4.317c.426-1.756 2.924-1.756 3.35 0a1.724 1.724 0 002.573 1.066c1.543-.94 3.31.826 2.37 2.37a1.724 1.724 0 001.065 2.572c1.756.426 1.756 2.924 0 3.35a1.724 1.724 0 00-1.066 2.573c.94 1.543-.826 3.31-2.37 2.37a1.724 1.724 0 00-2.572 1.065c-.426 1.756-2.924 1.756-3.35 0a1.724 1.724 0 00-2.573-1.066c-1.543.94-3.31-.826-2.37-2.37a1.724 1.724 0 00-1.065-2.572c-1.756-.426-1.756-2.924 0-3.35a1.724 1.724 0 001.066-2.573c-.94-1.543.826-3.31 2.37-2.37.996.608 2.296.07 2.572-1.065z"
                    />
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      stroke-width="2"
                      d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
                    />
                  </svg>
                  Tugatilganlar
                </NuxtLink>
              </div>
            </div>
          </nav>
        </div>
      </div>
    </div>

    <div class="flex-1 overflow-auto focus:outline-none">
      <div
        class="relative z-10 flex-shrink-0 flex h-16 bg-white border-b border-gray-200 lg:border-none"
      >
        <button
          class="px-4 border-r border-gray-200 text-gray-400 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-cyan-500 lg:hidden"
        >
          <span class="sr-only">Open sidebar</span>
          <!-- Heroicon name: outline/menu-alt-1 -->
          <svg
            class="h-6 w-6"
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
              d="M4 6h16M4 12h8m-8 6h16"
            />
          </svg>
        </button>
        <!-- Search bar -->
        <div
          class="flex-1 px-4 flex justify-end sm:px-6 lg:max-w-6xl lg:mx-auto lg:px-8"
        >
          <div class="ml-4 flex items-center md:ml-6">
            <button
              class="bg-white p-1 rounded-full text-gray-400 hover:text-gray-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-cyan-500"
            >
              <span class="sr-only">View notifications</span>
              <!-- Heroicon name: outline/bell -->
              <svg
                class="h-6 w-6"
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
                  d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9"
                />
              </svg>
            </button>

            <!-- Profile dropdown -->
            <div class="ml-3 relative">
              <div>
                <button
                  type="button"
                  class="max-w-xs bg-white rounded-full flex items-center text-sm focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-cyan-500 lg:p-2 lg:rounded-md lg:hover:bg-gray-50"
                  id="user-menu-button"
                  aria-expanded="false"
                  aria-haspopup="true"
                >
                  <img
                    class="h-8 w-8 rounded-full"
                    src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAyVBMVEX71DP///8UFRgAABb/2DT/2jT/2zT70yoQEhj70h4AABX70RENEBj70y370iX70iAFCxfwyzL833X+8cb955r71TjRsS3/+ur71j/++OP72lj84Hr+8MH84X///vr1zzLkwTA7NBvmwjDcui/+89D+9tqBbiNxYSGylynCpCuzmCn844n72En96KD83GVDOxwmIxn966z955seHRlaTh6jiidQRh1LQR1kVh8uKhojIRmLdyRvXyF8aiKHcySojyj97bWXgSXIqixp0xLoAAAPnUlEQVR4nN2d6ULqOheGW5K2hNIBZBIZVNAtgqjHCba6He7/or60QBnapJkK5XvPn31+VPOYZA3JSqLpmavXHHYea+PptD1ptepavd6atKfVce2xMzztZf/rtSx/ePPkrtuuezbyXMtyHEdbCf/bslwPIVRvn911TrNsRFaEzZPaFKO51horWU5AarfHnWZGLcmCsNnpthBy09i2ORFqdTOhVE44HE9sL7Xnkik9ezIeqm6QUsLeyZmLhOgiShe5Zycq26SSMMSToFvJQlZXYU+qIjwdq8GLIGuqDKwawk7bdpXhLeTa046StikgbNY8JDP3SHKQV1NgXKUJT8+Q6u5by/W60oyShFdTW93sS5Jln0lOSClCzJfF8NxhRFUpRgnCZnUPfCGjfSYxVoUJe+OMx+cWI6oJZyGihI9udvYlSa4j6jvECK8maK98gVBbbDoKEY73NAG35aDangiHzn4H6FpeXSBe5SbsdQ/SgQs59jhzwsN14EJu6ypbwtoBO3Ahx77LkLDX3r8JjQtNuXwjD+HQ2p+Pp8nSeEYqB+GdfWi0lRz7MQvCah5G6EroTDlhb3JYG7ort806GRkJT6VW0LKQVWfMN9gIh5ksU8jJ8dgCHCbCx9zYmC3ZTAurLIQ5BcSILBkVA2F+vERMLF4jnfC//AIyIaYS5hqQBTGNMMdDdKFUxBTC3BqZtexvGcLv/AOmOg0q4ckxAGJEaqpBI7zKU6xNk0cL4CiETa6d+EPKqVPCcArh5FgAcRjeFiGc5itdossl54tEwtqxTMKFENEtkgiPxIyuRTSoBMLmcfWgFhSSEawNgfCIrMxK1pSHsOYdur0CQslLxYmEw2ObhAslT8Ukwp5zfGM0kNNiJazmY2mbX27SzlQC4dE5irXshOW3BMJj7UEtCFBZCLvHFK3tyo1vhMcIj9SOroRi5QwxwtZx2tGVnEka4ePRhWs7QrurxDuEvWOehEvRCcfShNAwITShyJf4Q8MQ+XJL7n80wlNpM2Oe/7w+zGc3fYPzQ6N/M5s/vH42TNkmoB6FUDaagdonAH657ANww9dS82v14Udfsht3IpstwivJLoSXD6CwUBH84elF+AGKyy/B07kkot0kErblPAW89P1CJPDMjghfwfpDH0giWmckQlln33/aAMSI16wD1fwEmx/6T325hmy5/U1CyS40n7faWSiURmy9aNzufAie5czNViduEErOwlg7C8UiW19UojkYId7ymuJtbc7EDcKppCEt7baTcZyaf3b/NIWiL9cUq5tEeCoXrxk/sXZixMt0mwEHSR++yHXixk7GmnAs14X9eBeydaL5pxT/sFiQasxmFhUR9uRmIbxJ6AnsFdNnYiXpQzwT5TyGFyd8lFtANC/KiQ29SWuo8ZJI6N/LmdN1ihERyq0Bw/OEoRY09DWtoYQ/TaHEMIUpctq7hLKuIrkn0m0NvCR9KGlr7NMdQsm0yXz1CQ1NGabwi0CY3vt0RfH3ilDSF/YJ7SyUPugNNT8IfxoWI0WVtU14IucM4S+JsOjTB5sRi2ei3v+Vs6boZItQMjEkTsM0iwHPiR/KTsRVcLog7EmuPyV6bZaugCPyn+aPZLbv9jYIO7KE82STn9oVibHeQuW5JOHSJS4Iz2RXL4jtxIEblfCT2PkFIDdKV8N0QSi5wkZ0aoU0q2++EUxpQHgp16qlNQ0Jh5KDNDE9WA22CyohIaIJCQeS6zVoGBFKphUUZ4HdxQO1nU8kZ4EJG7KLbrWIULYugWIRcR5E89x9n0I4kiRc7GEEhE3ZdeDk1GlJWKIRJqdOS0LJBGq5mBEQfstWXtAIC6BC+ZJKmJp5pcnrLAm7sru+eSUMl2sCwrrsliGMLbMpIZQepWFxhqaiwotqacoHszTYXzRDQtmQLcVbPFE/zdJbLPILTFiT3zMU9/jkgFbe4y88oia9mK9lF7VJEzrTkFBF8QUl8v6kBdCUtEs68g6EAkL5fV/c0L/E6QR+DpU9BcI+X5NdwAhlzoiDjW4Rs8yAA2FTo+l3CsovKF1B3+6k2CjZVYxQ7h0mlM1+w4YSu6KYMpsMMqHkSlQoHNVoagqeibGJP0tZTXwmjW/Z1cRQThsTKvg5uCvuSSvCXyl9SFql898UTENNq+ua7DLbQsY7aXE+peqAOBHpNphZqKdJbowuRWooPaIJZBCimpJszclC6FSTXaNZynxI3l1LNYgEM5z+p2ETGmrS6e9ChPlETZ1CESK+tPnLKq+jqXCHgeIFFUE7Gbx2YrRAX/vgkPuo1RSVdZv/kgoOGNID2Ej68F1NF2pWTZNdSYzUj3ciSNlaWyjBJUpvrUWyxtqZqqrn+EwsggqLPUzYf1I1C7HLr2pTZXXdMa/P2k5z15z6b6oAcYaoqTulhq3i1jhlr04z7reyxKKC3Hclp61NVP0s3NDfTURwz/wh7D9sdH9ZwQLNWhOtpe6HaeYIRC0Fbxp7O2F/Hg1UHzSUjVGsllJCzTi/AMH6YBlwmnsIP0vBACj64O1SJaBWx/+pFDRGzz4Af98veYMuc/BZAMCfjeSr9bekli8QNGGlYgo0ExpmpSJ2joEu9Yz5kupRmj/V1VqaHKql0h/mUhNNfk0/18Ixjbq4NJfCcWn1/5ywqi4/zKdwfqgqx8+pcI7/+H9wapQi91HrHOMlH+zyOqrWS/MqdCK85g1xpGxmECcrFjoV27eApja4/TebK9kBS1Ol0jdFkpVQqCey92TA0QznclhKs3GC4AD4F7OfUd8U+mW6xl2KAeFXIUzki3sBDA/flnBWDd6+Ktx7Gc6Efw/YHP1drDftCzBYUA3PF2PK6wrnr7TOuPfxjc9SubBfwPUR6iL3IfhwH5+rFiM6dL1PwACx7C9/7QfksTlhLQZP/azxfBDAzYPwHMuwWni+S9N19j40rw8EuNGLBfDG0YmIr64NNkqHAtxCZD7nH55C5KlNhPP9G5mN337pLzfSS8yr/sERPY760qgSuDQ4AGCAuCxGLc9ZCYODQRw1wlEtKPg9DGFU78FcAb6sEWas817vRqvc/eJRVO7BWqgRXm7GXqtvrDfq/QeplorJ/FjvozKWD4dnu9jPW4R2priwZ+B17+PUXG6ig6AjGXe2vG+eMzNh3Uu5sDzRzFJGolTG78JTgZ+5HwxTJsLozAzTHW1BgWW5NFiVzXA4JRXCVib8vf6FWfnrs1QiaZvnnpiOqhsvoAwGRnRHC3jfI2LkC0EDwgCR6SyGNeY6f2h8AhD4wWjC7xERVlbzPxg5sPLgM1Uubpw/ZDlDar6CpaN/WrnFf3tCDJAWXuJp9f/0EwBLbZwhZTmsbj4sAdd+ke86L2HByur+qVW4BvsPDDcubJ0DZgjcYOSCzKj4CTxz1FuIyjgv+ruDBlYYKoi3znL3GDzimsWcRYgXvMsK3DIbYDkr/It1EyBD3dvWeXzeOxXmq7IZ35e/BZAq82Z9VR1frLh9pwLnsZKN+q4i+MlwWRia71E9GLjhGy4792LofLsXxkZNKHjNbKTC/vouPu4Qw9W3CTm3Ec3bda2dXxplM1LNRiH6LaV7zj9j7H4a3juGNismi2DGfZlnuiB8L0XV8f4T742YsTuGuI/ObFU9g+JI9Ww0G/PNvyHv2YT4PVH8R9a3rnMsgudzlUPV6H+uO1BkYSjhri+ORcVVK2abpb0+uFY2VKFxAzZ/NuCf6An3tQnchWV8bFUvA/CjqWCE5uhiq9q4dMsN6N4lEAocWt+507EI/Je+7Hw0DMy3fQ/qF//4R0n3JorcFbVztWrA+F6RYISGdjPf5iuUXvgBk+++FDoQHCuzLwIwa0CxHVtoVn7KoLzz8zh3m0IR7i/VRQrAzJvYnZc+eHgfcG9LQxP+zsDuqZSiUDRBuoNW7GZB8xfEjryUAZi/DNhvH4eG2R/9AfEfJFjVTrxHWKgTNeNynnBwKYD8NwrKoVMwMZ0xeHkFIOFgPvh7LgJoVXUSodj1kBB+JCCGkKX55+0grKSIgwZXzJtGpfGCxyZIvABENMGm3OctevWe+RUfYBEl8C/+/Iwa5/1lCY4ZAmuVwejl/fWJRBfYGMHza5uGNEYoer+COUgaqaumlktBZUoJPF28PT/PZs+v93M/LFYhwQXyBQKZhVCTQih8ySeE/wD5lpII1V+qTCZbCryJZp27D7Hsvm8hXOVmNp4o9wVxygcv4gdLelRCieuEcT5Hmo2cKoJX7iM3kdLeKJF6Z8Y8fy7JM+Ko6FY88HNir1kqfSsImo379OlIFwDvMhmKnf5WkNx7T9AY7UbOfHylT/7itQ0lvEsWJ5R8TAdnd/eCjHh8Xl9KZV9sb3bpHdmXSoxGPIROlw/8H5nMK1DS+4CZvJ0HzcsfPOA4IMug9HorvULA+naeivcPcYY4+lNk7Ekc4Mx/zuUX69jfP1Tz9ho0td/rAg7YaMa1iOlK9z8cmRZF7G9YqnjYKhSOtM9vP+fJEWgxjE3v/wXlzWouauF4h1ThW7IQmsbl79f1MyiBLZWKz9dfDVV0Gu9bsnpT6TmTIBM0tctBY/T19fLydXPbGFQgTqJUHmp2LL73gLN4qhMGMrBgQj4sraQHOqmEx/Yut839Lrf800F7ldslcpAJe0f0mqUVyyhYCI/o9XGnTrAyKYTST+ntTV6TQkEjPJa3j5NjGSZC/fEYEO3ddQseQv0u/4j2Nx0hhTD/bpHsCBkJ845oJ4fbPIT6OM+I6YAMhHotv3MxdYiyEebX3KQZGWZC/TufiClugocQu/78xaiOR3X0nIT6lZc3RMeJrW5LEerNVr6SKXdCCbaFCPXeNE9eA1XTW8xLmCuvweAGRQj1Tk4mo+WS1mRkCfXmJA+X2aA26xTkJ8Qh3MFHqsMzQgUI9RPrsDbVrbN5QXFCvVc9YDc6dtLukmJCbHDcQ81G/g4UI9T17kGCOAfxd6AooX412b/7R23GME0Joa4/Wvsdqq7FkimpJNR7Y3t/VtVCNS4fqIQQ+//qnqajZXdpS77ZEeLpOEXZM1poKjYBVRAGjBmPVcuuSvFJE+r6adfLzua46EySTwEhno//oUwGq+OhmsT8U0iI1WnbqjvSstui/mFbagjxYK1pSN2MtJA3lh6eS6kixBp2LSWQGK96oq5ZCgmxTgJImTnpuMiqdoS9e5LUEmINxy3bE+pKx/LsVo1ngYJJygmxmt9ndYRcnr7EfYda3Y4C0xlTFoSBmie1qWcjN23MOo7lItud1k6yoAuUFWGo5vCxO9EQQp5rWc5GTSf+t2W5HrK9Vrt7lxlcqEwJF+qdDr/vauOzaXsyadW1eqs1aU+n49pjZ9hUalOS9T9egiUTFdWchAAAAABJRU5ErkJggg=="
                    alt=""
                  />
                  <span
                    class="hidden ml-3 text-gray-700 text-sm font-medium lg:block"
                    ><span class="sr-only">Open user menu for </span>Emilia
                    Birch</span
                  >
                  <!-- Heroicon name: solid/chevron-down -->
                  <svg
                    class="hidden flex-shrink-0 ml-1 h-5 w-5 text-gray-400 lg:block"
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                  >
                    <path
                      fill-rule="evenodd"
                      d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z"
                      clip-rule="evenodd"
                    />
                  </svg>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <main class="flex-1 relative pb-8 z-0 overflow-y-auto">
        <!-- Page header -->
        <Nuxt />
      </main>
    </div>
  </div>
</template>

<script>
export default {};
</script>
