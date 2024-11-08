USE [motel3]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Category_id] [int] NOT NULL,
	[Type_id] [int] NULL,
	[Category_Name] [varchar](100) NULL,
	[Description] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[Category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contract]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contract](
	[Contract_id] [int] IDENTITY(1,1) NOT NULL,
	[Room_id] [int] NULL,
	[User_ID] [int] NULL,
	[Guest_id] [int] NULL,
	[CreateAt] [date] NULL,
	[Motel_id] [int] NULL,
	[Total_Price] [decimal](10, 2) NULL,
	[Payment_method] [varchar](50) NULL,
	[Payment_Status] [varchar](50) NULL,
	[Payment_Date] [date] NULL,
	[TypeOfContract] [varchar](50) NULL,
	[Start_date] [date] NULL,
	[End_date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Contract_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Fee_Include]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Fee_Include](
	[FeeInclude_id] [int] IDENTITY(1,1) NOT NULL,
	[Note] [text] NULL,
	[Count] [int] NULL,
	[Price] [decimal](10, 2) NULL,
	[Unit] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[FeeInclude_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Fee_Include_Line]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Fee_Include_Line](
	[FeeIncludeLine_id] [int] IDENTITY(1,1) NOT NULL,
	[PaymentLine_id] [int] NULL,
	[FeeInclude_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[FeeIncludeLine_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Guest]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Guest](
	[Guest_id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](100) NULL,
	[Email] [varchar](100) NULL,
	[PhoneNum] [varchar](15) NULL,
	[Identity_id] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Guest_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Image]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Image](
	[Image_id] [int] NOT NULL,
	[Category] [varchar](100) NULL,
	[Image_Url] [varchar](255) NULL,
	[Room_id] [int] NULL,
	[Post_id] [int] NULL,
	[Motel_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Image_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Motels]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Motels](
	[Motel_id] [int] NOT NULL,
	[Motel_name] [varchar](100) NULL,
	[Description] [text] NULL,
	[Image_Url] [varchar](255) NULL,
	[Address] [varchar](255) NULL,
	[City] [varchar](100) NULL,
	[NumberOfRoom] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Motel_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment_Line]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment_Line](
	[PaymentLine_id] [int] IDENTITY(1,1) NOT NULL,
	[Status] [varchar](50) NULL,
	[Price_per_month] [decimal](10, 2) NULL,
	[Available_Guest] [int] NULL,
	[Description] [text] NULL,
	[Record_id] [int] NULL,
	[Billing_Period] [varchar](50) NULL,
	[Total_Payment] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[PaymentLine_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment_Record]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment_Record](
	[Record_id] [int] IDENTITY(1,1) NOT NULL,
	[Date] [date] NULL,
	[Room_id] [int] NULL,
	[Total_Discount] [decimal](10, 2) NULL,
	[Motel_id] [int] NULL,
	[Guest_id] [int] NULL,
	[Contract_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Record_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post](
	[Post_id] [int] NOT NULL,
	[Title] [varchar](255) NULL,
	[Content] [text] NULL,
	[Created_at] [date] NULL,
	[Image_Url] [varchar](255) NULL,
	[Updated_at] [date] NULL,
	[Category] [varchar](100) NULL,
	[Staff_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Post_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rent_Contact]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rent_Contact](
	[RentContract_id] [int] IDENTITY(1,1) NOT NULL,
	[Guest_name] [varchar](100) NULL,
	[Room_id] [int] NULL,
	[Start_date] [date] NULL,
	[End_date] [date] NULL,
	[Phone_number] [varchar](15) NULL,
	[Email] [varchar](100) NULL,
	[Address] [varchar](255) NULL,
	[Status] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[RentContract_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[Room_id] [int] NOT NULL,
	[Motel_id] [int] NULL,
	[Type_Id] [int] NULL,
	[Image_Url] [varchar](255) NULL,
	[Status] [varchar](20) NULL,
	[Price] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[Room_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room_Type]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room_Type](
	[Type_id] [int] NOT NULL,
	[Name] [varchar](100) NULL,
	[Description] [text] NULL,
	[Max_Guest] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 11/7/2024 12:51:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[User_id] [int] IDENTITY(1,1) NOT NULL,
	[User_Name] [varchar](100) NULL,
	[Password] [varchar](255) NULL,
	[Role] [varchar](50) NULL,
	[Email] [varchar](100) NULL,
	[Phone_Num] [varchar](15) NULL,
	[Identity_Id] [varchar](50) NULL,
	[Status] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[User_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Categories] ([Category_id], [Type_id], [Category_Name], [Description]) VALUES (4, 1, N'Single Bed', N'A comfortable single bed for one person.')
INSERT [dbo].[Categories] ([Category_id], [Type_id], [Category_Name], [Description]) VALUES (5, 1, N'Table', N'A small table for personal use.')
INSERT [dbo].[Categories] ([Category_id], [Type_id], [Category_Name], [Description]) VALUES (6, 2, N'Double Bed', N'A spacious double bed for two people.')
INSERT [dbo].[Categories] ([Category_id], [Type_id], [Category_Name], [Description]) VALUES (7, 2, N'Coffee Table', N'A coffee table for the sitting area.')
INSERT [dbo].[Categories] ([Category_id], [Type_id], [Category_Name], [Description]) VALUES (8, 3, N'Family Bed', N'A large bed suitable for family use.')
INSERT [dbo].[Categories] ([Category_id], [Type_id], [Category_Name], [Description]) VALUES (9, 3, N'Dining Table', N'A dining table for family meals.')
GO
SET IDENTITY_INSERT [dbo].[Contract] ON 

INSERT [dbo].[Contract] ([Contract_id], [Room_id], [User_ID], [Guest_id], [CreateAt], [Motel_id], [Total_Price], [Payment_method], [Payment_Status], [Payment_Date], [TypeOfContract], [Start_date], [End_date]) VALUES (1, NULL, 1, NULL, CAST(N'2024-09-01' AS Date), 1, CAST(100.00 AS Decimal(10, 2)), N'Credit Card', N'Paid', CAST(N'2024-09-01' AS Date), N'Short-Term', CAST(N'2024-09-01' AS Date), CAST(N'2024-09-10' AS Date))
INSERT [dbo].[Contract] ([Contract_id], [Room_id], [User_ID], [Guest_id], [CreateAt], [Motel_id], [Total_Price], [Payment_method], [Payment_Status], [Payment_Date], [TypeOfContract], [Start_date], [End_date]) VALUES (2, NULL, 2, NULL, CAST(N'2024-09-10' AS Date), 1, CAST(200.00 AS Decimal(10, 2)), N'Debit Card', N'Unpaid', CAST(N'2024-09-10' AS Date), N'Short-Term', CAST(N'2024-09-10' AS Date), CAST(N'2024-09-20' AS Date))
INSERT [dbo].[Contract] ([Contract_id], [Room_id], [User_ID], [Guest_id], [CreateAt], [Motel_id], [Total_Price], [Payment_method], [Payment_Status], [Payment_Date], [TypeOfContract], [Start_date], [End_date]) VALUES (3, NULL, 3, NULL, CAST(N'2024-09-15' AS Date), 2, CAST(400.00 AS Decimal(10, 2)), N'Cash', N'Paid', CAST(N'2024-09-15' AS Date), N'Long-Term', CAST(N'2024-09-15' AS Date), CAST(N'2024-12-15' AS Date))
INSERT [dbo].[Contract] ([Contract_id], [Room_id], [User_ID], [Guest_id], [CreateAt], [Motel_id], [Total_Price], [Payment_method], [Payment_Status], [Payment_Date], [TypeOfContract], [Start_date], [End_date]) VALUES (4, NULL, 1, NULL, CAST(N'2024-11-01' AS Date), 2, CAST(1500.00 AS Decimal(10, 2)), N'Cash', N'Paid', CAST(N'2024-11-01' AS Date), N'Long-Term', CAST(N'2024-11-01' AS Date), CAST(N'2025-11-01' AS Date))
INSERT [dbo].[Contract] ([Contract_id], [Room_id], [User_ID], [Guest_id], [CreateAt], [Motel_id], [Total_Price], [Payment_method], [Payment_Status], [Payment_Date], [TypeOfContract], [Start_date], [End_date]) VALUES (5, NULL, 2, NULL, CAST(N'2025-05-01' AS Date), 2, CAST(1050.00 AS Decimal(10, 2)), N'Credit Card', N'Pending', CAST(N'2025-05-01' AS Date), N'Short-Term', CAST(N'2025-05-01' AS Date), CAST(N'2025-05-31' AS Date))
INSERT [dbo].[Contract] ([Contract_id], [Room_id], [User_ID], [Guest_id], [CreateAt], [Motel_id], [Total_Price], [Payment_method], [Payment_Status], [Payment_Date], [TypeOfContract], [Start_date], [End_date]) VALUES (6, NULL, 3, NULL, CAST(N'2025-12-01' AS Date), 3, CAST(3150.00 AS Decimal(10, 2)), N'Bank Transfer', N'Paid', CAST(N'2025-12-01' AS Date), N'Long-Term', CAST(N'2025-12-01' AS Date), CAST(N'2026-12-01' AS Date))
SET IDENTITY_INSERT [dbo].[Contract] OFF
GO
SET IDENTITY_INSERT [dbo].[Fee_Include] ON 

INSERT [dbo].[Fee_Include] ([FeeInclude_id], [Note], [Count], [Price], [Unit]) VALUES (1, N'Electricity fee', 250, CAST(0.25 AS Decimal(10, 2)), N'kWh')
INSERT [dbo].[Fee_Include] ([FeeInclude_id], [Note], [Count], [Price], [Unit]) VALUES (2, N'Water fee', 50, CAST(4.00 AS Decimal(10, 2)), N'm³')
INSERT [dbo].[Fee_Include] ([FeeInclude_id], [Note], [Count], [Price], [Unit]) VALUES (3, N'Service fee', 1, CAST(60.00 AS Decimal(10, 2)), N'service')
INSERT [dbo].[Fee_Include] ([FeeInclude_id], [Note], [Count], [Price], [Unit]) VALUES (4, N'Cleaning fee', 1, CAST(150.00 AS Decimal(10, 2)), N'service')
INSERT [dbo].[Fee_Include] ([FeeInclude_id], [Note], [Count], [Price], [Unit]) VALUES (5, N'Internet fee', 1, CAST(100.00 AS Decimal(10, 2)), N'service')
INSERT [dbo].[Fee_Include] ([FeeInclude_id], [Note], [Count], [Price], [Unit]) VALUES (6, N'Parking fee', 1, CAST(200.00 AS Decimal(10, 2)), N'service')
SET IDENTITY_INSERT [dbo].[Fee_Include] OFF
GO
SET IDENTITY_INSERT [dbo].[Fee_Include_Line] ON 

INSERT [dbo].[Fee_Include_Line] ([FeeIncludeLine_id], [PaymentLine_id], [FeeInclude_id]) VALUES (1, 1, 1)
INSERT [dbo].[Fee_Include_Line] ([FeeIncludeLine_id], [PaymentLine_id], [FeeInclude_id]) VALUES (2, 2, 2)
INSERT [dbo].[Fee_Include_Line] ([FeeIncludeLine_id], [PaymentLine_id], [FeeInclude_id]) VALUES (3, 3, 3)
INSERT [dbo].[Fee_Include_Line] ([FeeIncludeLine_id], [PaymentLine_id], [FeeInclude_id]) VALUES (4, 4, 4)
INSERT [dbo].[Fee_Include_Line] ([FeeIncludeLine_id], [PaymentLine_id], [FeeInclude_id]) VALUES (5, 5, 5)
INSERT [dbo].[Fee_Include_Line] ([FeeIncludeLine_id], [PaymentLine_id], [FeeInclude_id]) VALUES (6, 6, 6)
SET IDENTITY_INSERT [dbo].[Fee_Include_Line] OFF
GO
SET IDENTITY_INSERT [dbo].[Guest] ON 

INSERT [dbo].[Guest] ([Guest_id], [Name], [Email], [PhoneNum], [Identity_id]) VALUES (1, N'Nguyen Van A', N'nguyenvana@example.com', N'0912345678', N'ID001')
INSERT [dbo].[Guest] ([Guest_id], [Name], [Email], [PhoneNum], [Identity_id]) VALUES (2, N'Tran Thi B', N'tranthib@example.com', N'0912345679', N'ID002')
INSERT [dbo].[Guest] ([Guest_id], [Name], [Email], [PhoneNum], [Identity_id]) VALUES (3, N'Le Van C', N'levanc@example.com', N'0912345680', N'ID003')
INSERT [dbo].[Guest] ([Guest_id], [Name], [Email], [PhoneNum], [Identity_id]) VALUES (4, N'Pham Thi D', N'phamthid@example.com', N'0912345681', N'ID004')
INSERT [dbo].[Guest] ([Guest_id], [Name], [Email], [PhoneNum], [Identity_id]) VALUES (5, N'Hoang Van E', N'hoangvane@example.com', N'0912345682', N'ID005')
INSERT [dbo].[Guest] ([Guest_id], [Name], [Email], [PhoneNum], [Identity_id]) VALUES (6, N'Bui Thi F', N'buithef@example.com', N'0912345683', N'ID006')
SET IDENTITY_INSERT [dbo].[Guest] OFF
GO
INSERT [dbo].[Image] ([Image_id], [Category], [Image_Url], [Room_id], [Post_id], [Motel_id]) VALUES (1, N'Room', N'images/room-1.jpg', 101, 1, 1)
INSERT [dbo].[Image] ([Image_id], [Category], [Image_Url], [Room_id], [Post_id], [Motel_id]) VALUES (2, N'Room', N'images/room-2.jpg', 102, 1, 1)
INSERT [dbo].[Image] ([Image_id], [Category], [Image_Url], [Room_id], [Post_id], [Motel_id]) VALUES (3, N'Room', N'images/room-3.jpg', 103, 2, 1)
INSERT [dbo].[Image] ([Image_id], [Category], [Image_Url], [Room_id], [Post_id], [Motel_id]) VALUES (4, N'Room', N'images/room-4.jpg', 104, 2, 2)
GO
INSERT [dbo].[Motels] ([Motel_id], [Motel_name], [Description], [Image_Url], [Address], [City], [NumberOfRoom]) VALUES (1, N'Quang Anh Motel', N'cheap student motel.', N'images/motel-1.jpg', N'village 1 hoa lac', N'tan xa', 50)
INSERT [dbo].[Motels] ([Motel_id], [Motel_name], [Description], [Image_Url], [Address], [City], [NumberOfRoom]) VALUES (2, N'Hung brother motel', N'luxury motel for family.', N'images/motel-2.jpg', N'village 2 hoa lac', N'Thach Hoa', 30)
INSERT [dbo].[Motels] ([Motel_id], [Motel_name], [Description], [Image_Url], [Address], [City], [NumberOfRoom]) VALUES (3, N'Grandma Thanh Motel', N'Motel Like Stay with Grandma.', N'images/motel-3.jpg', N'village 3 hoa lac', N'hinh yen', 50)
INSERT [dbo].[Motels] ([Motel_id], [Motel_name], [Description], [Image_Url], [Address], [City], [NumberOfRoom]) VALUES (4, N'Mr.Duc motel', N'Home Sweet Home.', N'images/motel-4.jpg', N'village 4 hoa lac', N'hoa lac', 30)
GO
SET IDENTITY_INSERT [dbo].[Payment_Line] ON 

INSERT [dbo].[Payment_Line] ([PaymentLine_id], [Status], [Price_per_month], [Available_Guest], [Description], [Record_id], [Billing_Period], [Total_Payment]) VALUES (1, N'Paid', CAST(100.00 AS Decimal(10, 2)), 1, N'Monthly rent for room 101', 1, N'2 months', CAST(200.00 AS Decimal(10, 2)))
INSERT [dbo].[Payment_Line] ([PaymentLine_id], [Status], [Price_per_month], [Available_Guest], [Description], [Record_id], [Billing_Period], [Total_Payment]) VALUES (2, N'Pending', CAST(200.00 AS Decimal(10, 2)), 2, N'Monthly rent for room 102', 2, N'6 months', CAST(1200.00 AS Decimal(10, 2)))
INSERT [dbo].[Payment_Line] ([PaymentLine_id], [Status], [Price_per_month], [Available_Guest], [Description], [Record_id], [Billing_Period], [Total_Payment]) VALUES (3, N'Paid', CAST(300.00 AS Decimal(10, 2)), 4, N'Monthly rent for room 103', 3, N'9 months', CAST(2700.00 AS Decimal(10, 2)))
INSERT [dbo].[Payment_Line] ([PaymentLine_id], [Status], [Price_per_month], [Available_Guest], [Description], [Record_id], [Billing_Period], [Total_Payment]) VALUES (4, N'Paid', CAST(250.00 AS Decimal(10, 2)), 3, N'Monthly rent for room 104', 4, N'6 months', CAST(1500.00 AS Decimal(10, 2)))
INSERT [dbo].[Payment_Line] ([PaymentLine_id], [Status], [Price_per_month], [Available_Guest], [Description], [Record_id], [Billing_Period], [Total_Payment]) VALUES (5, N'Pending', CAST(150.00 AS Decimal(10, 2)), 1, N'Monthly rent for room 105', 5, N'7 months', CAST(1050.00 AS Decimal(10, 2)))
INSERT [dbo].[Payment_Line] ([PaymentLine_id], [Status], [Price_per_month], [Available_Guest], [Description], [Record_id], [Billing_Period], [Total_Payment]) VALUES (6, N'Paid', CAST(350.00 AS Decimal(10, 2)), 2, N'Monthly rent for room 106', 6, N'9 months', CAST(3150.00 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[Payment_Line] OFF
GO
SET IDENTITY_INSERT [dbo].[Payment_Record] ON 

INSERT [dbo].[Payment_Record] ([Record_id], [Date], [Room_id], [Total_Discount], [Motel_id], [Guest_id], [Contract_id]) VALUES (1, CAST(N'2024-01-01' AS Date), 101, CAST(0.00 AS Decimal(10, 2)), 1, 1, 1)
INSERT [dbo].[Payment_Record] ([Record_id], [Date], [Room_id], [Total_Discount], [Motel_id], [Guest_id], [Contract_id]) VALUES (2, CAST(N'2024-04-01' AS Date), 102, CAST(0.00 AS Decimal(10, 2)), 1, 2, 2)
INSERT [dbo].[Payment_Record] ([Record_id], [Date], [Room_id], [Total_Discount], [Motel_id], [Guest_id], [Contract_id]) VALUES (3, CAST(N'2024-10-01' AS Date), 103, CAST(0.00 AS Decimal(10, 2)), 1, 3, 3)
INSERT [dbo].[Payment_Record] ([Record_id], [Date], [Room_id], [Total_Discount], [Motel_id], [Guest_id], [Contract_id]) VALUES (4, CAST(N'2024-11-01' AS Date), 104, CAST(10.00 AS Decimal(10, 2)), 2, 4, 4)
INSERT [dbo].[Payment_Record] ([Record_id], [Date], [Room_id], [Total_Discount], [Motel_id], [Guest_id], [Contract_id]) VALUES (5, CAST(N'2025-05-01' AS Date), 105, CAST(5.00 AS Decimal(10, 2)), 2, 5, 5)
INSERT [dbo].[Payment_Record] ([Record_id], [Date], [Room_id], [Total_Discount], [Motel_id], [Guest_id], [Contract_id]) VALUES (6, CAST(N'2025-12-01' AS Date), 106, CAST(0.00 AS Decimal(10, 2)), 3, 6, 6)
SET IDENTITY_INSERT [dbo].[Payment_Record] OFF
GO
INSERT [dbo].[Post] ([Post_id], [Title], [Content], [Created_at], [Image_Url], [Updated_at], [Category], [Staff_id]) VALUES (1, N'Welcome to Quang Anh Motel', N'Experience the best stay at Quang Anh Motel.', CAST(N'2024-01-01' AS Date), N'images/post-1.jpg', CAST(N'2024-01-02' AS Date), N'Introduction', 2)
INSERT [dbo].[Post] ([Post_id], [Title], [Content], [Created_at], [Image_Url], [Updated_at], [Category], [Staff_id]) VALUES (2, N'Special Offers for Families', N'Enjoy special discounts for family rooms.', CAST(N'2024-02-01' AS Date), N'images/post-2.jpg', CAST(N'2024-02-05' AS Date), N'Promotion', 2)
GO
SET IDENTITY_INSERT [dbo].[Rent_Contact] ON 

INSERT [dbo].[Rent_Contact] ([RentContract_id], [Guest_name], [Room_id], [Start_date], [End_date], [Phone_number], [Email], [Address], [Status]) VALUES (1, N'Nguyen Van A', 101, CAST(N'2024-01-01' AS Date), CAST(N'2024-01-10' AS Date), N'0912345678', N'nguyenvana@example.com', N'123 Main St', N'INACTIVE')
INSERT [dbo].[Rent_Contact] ([RentContract_id], [Guest_name], [Room_id], [Start_date], [End_date], [Phone_number], [Email], [Address], [Status]) VALUES (2, N'Tran Thi B', 102, CAST(N'2024-02-01' AS Date), CAST(N'2024-02-15' AS Date), N'0912345679', N'tranthib@example.com', N'456 Elm St', N'INACTIVE')
SET IDENTITY_INSERT [dbo].[Rent_Contact] OFF
GO
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (101, 1, 1, N'images/room-1.jpg', N'Available', CAST(100.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (102, 1, 2, N'images/room-2.jpg', N'Available', CAST(200.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (103, 1, 3, N'images/room-3.jpg', N'Available', CAST(300.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (104, 2, 1, N'images/room-4.jpg', N'Available', CAST(100.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (105, 2, 2, N'images/room-5.jpg', N'Available', CAST(200.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (106, 2, 3, N'images/room-6.jpg', N'Available', CAST(300.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (107, 3, 1, N'images/room-7.jpg', N'Available', CAST(100.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (108, 3, 2, N'images/room-8.jpg', N'Available', CAST(200.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (109, 3, 3, N'images/room-9.jpg', N'Available', CAST(300.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (110, 4, 1, N'images/room-10.jpg', N'Available', CAST(100.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (111, 4, 2, N'images/room-11.jpg', N'Available', CAST(200.00 AS Decimal(10, 2)))
INSERT [dbo].[Room] ([Room_id], [Motel_id], [Type_Id], [Image_Url], [Status], [Price]) VALUES (112, 4, 3, N'images/room-12.jpg', N'Available', CAST(300.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Room_Type] ([Type_id], [Name], [Description], [Max_Guest]) VALUES (1, N'Single Room', N'One bed for one person.', 1)
INSERT [dbo].[Room_Type] ([Type_id], [Name], [Description], [Max_Guest]) VALUES (2, N'Double Room', N'Two beds for two people.', 2)
INSERT [dbo].[Room_Type] ([Type_id], [Name], [Description], [Max_Guest]) VALUES (3, N'Family Room', N'Large room for family.', 4)
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([User_id], [User_Name], [Password], [Role], [Email], [Phone_Num], [Identity_Id], [Status]) VALUES (1, N'admin123', N'admin123', N'Admin', N'admin@example.com', N'0123456789', N'ID123456', N'ACTIVE')
INSERT [dbo].[Users] ([User_id], [User_Name], [Password], [Role], [Email], [Phone_Num], [Identity_Id], [Status]) VALUES (2, N'staff001', N'staff123', N'Staff', N'staff001@example.com', N'0987654321', N'ID987654', N'ACTIVE')
INSERT [dbo].[Users] ([User_id], [User_Name], [Password], [Role], [Email], [Phone_Num], [Identity_Id], [Status]) VALUES (3, N'user001', N'user123', N'User', N'user001@example.com', N'0123894567', N'ID654321', N'ACTIVE')
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Rent_Contact] ADD  DEFAULT ('INACTIVE') FOR [Status]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT ('ACTIVE') FOR [Status]
GO
ALTER TABLE [dbo].[Categories]  WITH CHECK ADD FOREIGN KEY([Type_id])
REFERENCES [dbo].[Room_Type] ([Type_id])
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD FOREIGN KEY([Guest_id])
REFERENCES [dbo].[Guest] ([Guest_id])
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD FOREIGN KEY([Motel_id])
REFERENCES [dbo].[Motels] ([Motel_id])
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD FOREIGN KEY([Room_id])
REFERENCES [dbo].[Room] ([Room_id])
GO
ALTER TABLE [dbo].[Contract]  WITH CHECK ADD FOREIGN KEY([User_ID])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Fee_Include_Line]  WITH CHECK ADD FOREIGN KEY([FeeInclude_id])
REFERENCES [dbo].[Fee_Include] ([FeeInclude_id])
GO
ALTER TABLE [dbo].[Fee_Include_Line]  WITH CHECK ADD FOREIGN KEY([PaymentLine_id])
REFERENCES [dbo].[Payment_Line] ([PaymentLine_id])
GO
ALTER TABLE [dbo].[Image]  WITH CHECK ADD FOREIGN KEY([Motel_id])
REFERENCES [dbo].[Motels] ([Motel_id])
GO
ALTER TABLE [dbo].[Image]  WITH CHECK ADD FOREIGN KEY([Post_id])
REFERENCES [dbo].[Post] ([Post_id])
GO
ALTER TABLE [dbo].[Image]  WITH CHECK ADD FOREIGN KEY([Room_id])
REFERENCES [dbo].[Room] ([Room_id])
GO
ALTER TABLE [dbo].[Payment_Line]  WITH CHECK ADD FOREIGN KEY([Record_id])
REFERENCES [dbo].[Payment_Record] ([Record_id])
GO
ALTER TABLE [dbo].[Payment_Record]  WITH CHECK ADD FOREIGN KEY([Contract_id])
REFERENCES [dbo].[Contract] ([Contract_id])
GO
ALTER TABLE [dbo].[Payment_Record]  WITH CHECK ADD FOREIGN KEY([Guest_id])
REFERENCES [dbo].[Guest] ([Guest_id])
GO
ALTER TABLE [dbo].[Payment_Record]  WITH CHECK ADD FOREIGN KEY([Motel_id])
REFERENCES [dbo].[Motels] ([Motel_id])
GO
ALTER TABLE [dbo].[Payment_Record]  WITH CHECK ADD FOREIGN KEY([Room_id])
REFERENCES [dbo].[Room] ([Room_id])
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD FOREIGN KEY([Staff_id])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Rent_Contact]  WITH CHECK ADD FOREIGN KEY([Room_id])
REFERENCES [dbo].[Room] ([Room_id])
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD FOREIGN KEY([Motel_id])
REFERENCES [dbo].[Motels] ([Motel_id])
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD FOREIGN KEY([Type_Id])
REFERENCES [dbo].[Room_Type] ([Type_id])
GO
