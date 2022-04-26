package com.kata.foobarquix

import com.kata.foobarquix.controllers.FooBarQuixController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.hamcrest.Matchers.containsString
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc


@SpringBootTest
@AutoConfigureMockMvc
class FooBarQuixApplicationTests {

//	@Autowired
//	private val controller: FooBarQuixController? = null
//
//	@Test
//	fun contextLoads() {
//		assertThat(controller).isNotNull();
//	}

	@Autowired
	private val mockMvc: MockMvc? = null

	@Test
	@Throws(Exception::class)
	fun should_return_foo_when_input_number_is_divisible_by_3() {
		mockMvc!!.perform(get("/foo-bar-quix/9")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"Foo\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_foox3_when_input_number_is_33() {
		mockMvc!!.perform(get("/foo-bar-quix/33")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"FooFooFoo\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_foofoo_when_input_number_is_3() {
		mockMvc!!.perform(get("/foo-bar-quix/3")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"FooFoo\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_1_when_input_number_is_1() {
		mockMvc!!.perform(get("/foo-bar-quix/1")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"1\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_barbar_when_input_number_is_5() {
		mockMvc!!.perform(get("/foo-bar-quix/5")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"BarBar\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_quix_when_input_number_is_7() {
		mockMvc!!.perform(get("/foo-bar-quix/7")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"Quix\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_foo_when_input_number_is_9() {
		mockMvc!!.perform(get("/foo-bar-quix/9")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"Foo\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_foobar_when_input_number_is_51() {
		mockMvc!!.perform(get("/foo-bar-quix/51")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"FooBar\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_barfoo_when_input_number_is_53() {
		mockMvc!!.perform(get("/foo-bar-quix/53")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"BarFoo\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_fooquix_when_input_number_is_27() {
		mockMvc!!.perform(get("/foo-bar-quix/27")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"FooQuix\"}")))
	}

	@Test
	@Throws(Exception::class)
	fun should_return_foobarbar_when_input_number_is_15() {
		mockMvc!!.perform(get("/foo-bar-quix/15")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("{\"result\":\"FooBarBar\"}")))
	}


}
