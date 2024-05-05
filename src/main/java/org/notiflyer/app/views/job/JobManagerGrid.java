package org.notiflyer.app.views.job;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.notiflyer.app.config.ApplicationConfig;

import com.formdev.flatlaf.FlatClientProperties;

public class JobManagerGrid extends JPanel {

    public JobManagerGrid() {
        initialize();
    }
    
    private void initialize() {

        ApplicationConfig appConfig = new ApplicationConfig();

        // Database connection details
		String url = appConfig.DATABASE_URL;
		String username = appConfig.DATABASE_USER;
		String password = appConfig.DATABASE_PASSWORD;

		// SQL query to retrieve data from the table
		String query = "SELECT * FROM dbo.notiflyer_tbJobManager";

		try {
			// Establish the database connection
			Connection connection = DriverManager.getConnection(url, username, password);

			// Create a statement object
			Statement statement = connection.createStatement();

			// Execute the query
			ResultSet resultSet = statement.executeQuery(query);

			// Create a table model to hold the data
			DefaultTableModel tableModel = new DefaultTableModel();

			// Retrieve the column names from the result set
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				tableModel.addColumn(metaData.getColumnName(i));
			}

			// Retrieve the data from the result set
			while (resultSet.next()) {
				Object[] rowData = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					rowData[i - 1] = resultSet.getObject(i);
				}
				tableModel.addRow(rowData);
			}

			// Create a JTable component and set the table model
			JTable table = new JTable(tableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS,"table_style");
            table.putClientProperty(FlatClientProperties.STYLE_CLASS,"table_style");
            
			// Create a scroll pane and add the table to it
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportView(table);
            scrollPane.setSize(appConfig.MAIN_WINDOW_WIDTH, appConfig.MAIN_WINDOW_HEIGHT);

			// Create a JFrame and add the scroll pane to it
			// JPanel frame = new JPanel();
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setPreferredSize(new Dimension(appConfig.MAIN_WINDOW_WIDTH, appConfig.MAIN_WINDOW_HEIGHT));
            scrollPane.setPreferredSize(new Dimension(appConfig.MAIN_WINDOW_WIDTH-10, appConfig.MAIN_WINDOW_HEIGHT-90));
            this.add(scrollPane, BorderLayout.CENTER);
			//frame.pack();
			//frame.setVisible(true);

			// Close the resources
			resultSet.close();
			statement.close();
			connection.close();            
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
