package com.github.paf.service;

import com.github.paf.model.Payment;
import com.github.paf.repository.DBConnection;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {
	private DBConnection connection = new DBConnection();

	public Response addPayment(Payment payment) {
		int insertedId = -99;
		try {
			Connection con = connection.getConnection();
			if (con == null) return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("DataBase connectivity Error")
					.build();

			String query = "INSERT INTO payment(month, price, date, method) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStmt.setString(1, payment.getMonth());
			preparedStmt.setString(2, payment.getPrice());
			preparedStmt.setString(3, payment.getDate());
			preparedStmt.setString(4, payment.getMethod());

			preparedStmt.execute();
			ResultSet rs = preparedStmt.getGeneratedKeys();
			if (rs.next()){
				insertedId  = Integer.parseInt(rs.getString(1));
			}
			con.close();

			payment.setId(insertedId);
		} catch (Exception e) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(e)
					.build();
		}
		return Response
				.status(Response.Status.CREATED)
				.entity(payment)
				.build();
	}

	public Response getPayments() {
		List<Payment> payments = new ArrayList<Payment> ();

		try {
			Connection con = connection.getConnection();
			if (con == null) return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("DataBase connectivity Error")
					.build();

			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String month = rs.getString("month");
				String price = rs.getString("price");
				String date = rs.getString("date");
				String method = rs.getString("method");
				Payment payment = new Payment(month, price, date, method);
				payment.setId(id);
				payments.add(payment);

			}
			con.close();

		} catch (Exception e) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(e)
					.build();
		}

		return Response
				.status(Response.Status.OK)
				.entity(payments)
				.build();
	}

	public Response getPaymentById(Integer paymentid) {
		Payment payment = null;

		try {
			Connection con = connection.getConnection();
			if (con == null) return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("DataBase connectivity Error")
					.build();

			String query = "select * from payment where id = " + paymentid;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String month = rs.getString("month");
				String price = rs.getString("price");
				String date = rs.getString("date");
				String method = rs.getString("method");
				payment = new Payment(month, price, date, method);
				payment.setId(id);
			}
			con.close();

		} catch (Exception e) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(e)
					.build();
		}

		return Response
				.status(Response.Status.OK)
				.entity(payment)
				.build();
	}

	public Response deletePayment(Integer paymentid) {
		try {
			Connection con = connection.getConnection();
			if (con == null) return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("DataBase connectivity Error")
					.build();

			String query = "DELETE from payment WHERE id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, paymentid);

			preparedStmt.execute();
			con.close();

		} catch (Exception e) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(e)
					.build();
		}

		return Response
				.status(Response.Status.OK)
				.entity("Product Payment deleted successfully")
				.build();
	}

	public Response updatePayment(Payment payment) {
		try
		{
			Connection con = connection.getConnection();
			if (con == null) return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("DataBase connectivity Error")
					.build();

			String query = "UPDATE payment SET nic=?, month=?, price=?, date=? WHERE id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, payment.getMonth());
			preparedStmt.setString(2, payment.getPrice());
			preparedStmt.setString(3, payment.getDate());
			preparedStmt.setString(4, payment.getMethod());
			preparedStmt.setInt(5, payment.getId());

			preparedStmt.execute();
			con.close();
		}
		catch (Exception e)
		{
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Error while updating the item")
					.build();
		}

		return Response
				.status(Response.Status.CREATED)
				.entity(payment)
				.build();
	}

}
