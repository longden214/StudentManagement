Create database  [Manage_Student]
Go
USE [Manage_Student]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 1/22/2021 11:08:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten] [nvarchar](200) NULL,
	[password] [nvarchar](100) NULL,
	[role] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Attendance]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Attendance](
	[scheduleId] [int] NOT NULL,
	[idsv] [nvarchar](8) NOT NULL,
	[createdDate] [datetime] NULL,
	[updatedDate] [datetime] NULL,
	[status] [nvarchar](10) NULL DEFAULT ('P'),
	[note] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[scheduleId] ASC,
	[idsv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Class]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Class](
	[lop] [nvarchar](20) NOT NULL,
	[idFaculty] [int] NULL,
	[idCourse] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[lop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Course]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course](
	[maCourse] [nvarchar](20) NOT NULL,
	[startDate] [date] NULL,
	[endDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maCourse] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Faculty]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Faculty](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[khoa] [nvarchar](200) NULL,
	[year] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Mark]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mark](
	[idsv] [nvarchar](8) NOT NULL,
	[idmon] [int] NOT NULL,
	[diem] [float] NULL,
	[lanthi] [int] NOT NULL,
	[type] [int] NOT NULL,
	[ketqua] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[idsv] ASC,
	[idmon] ASC,
	[lanthi] ASC,
	[type] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Mark_type]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mark_type](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[schedule]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[schedule](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[subjectId] [int] NULL,
	[teacherId] [int] NULL,
	[classId] [nvarchar](20) NULL,
	[frameTime] [bit] NULL,
	[startTime] [time](7) NULL,
	[endTime] [time](7) NULL,
	[startDate] [date] NULL,
	[endDate] [date] NULL,
	[note] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sem]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sem](
	[idFaculty] [int] NOT NULL,
	[idmon] [int] NOT NULL,
	[year] [int] NULL,
	[sem] [int] NULL,
	[soTinchi] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idFaculty] ASC,
	[idmon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Student]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[idsv] [nvarchar](8) NOT NULL,
	[hoten] [nvarchar](200) NULL,
	[ngaysinh] [date] NULL,
	[phone] [nvarchar](11) NULL,
	[email] [nvarchar](200) NULL,
	[diachi] [nvarchar](200) NULL,
	[gioitinh] [bit] NULL,
	[idlop] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[idsv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Subject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subject](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[mon] [nvarchar](200) NULL,
	[idFaculty] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Teacher]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teacher](
	[idgv] [int] IDENTITY(1,1) NOT NULL,
	[hoten] [nvarchar](200) NULL,
	[phone] [nvarchar](11) NULL,
	[email] [nvarchar](100) NULL,
	[gender] [bit] NULL,
	[ngaysinh] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[idgv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Teacher_Class]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teacher_Class](
	[idgv] [int] NOT NULL,
	[idClass] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idgv] ASC,
	[idClass] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Teacher_Subject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teacher_Subject](
	[idgv] [int] NOT NULL,
	[idsb] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idgv] ASC,
	[idsb] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Admin] ON 

INSERT [dbo].[Admin] ([id], [ten], [password], [role]) VALUES (1, N'AdminRoot', N'123456', N'Admin')
INSERT [dbo].[Admin] ([id], [ten], [password], [role]) VALUES (2, N'LongDen', N'Longden@214', N'Teacher')
INSERT [dbo].[Admin] ([id], [ten], [password], [role]) VALUES (3, N'Nam', N'Nam@123456', N'Member')
INSERT [dbo].[Admin] ([id], [ten], [password], [role]) VALUES (1003, N'PhamDuyen', N'Duyen@123456', N'Teacher')
SET IDENTITY_INSERT [dbo].[Admin] OFF
INSERT [dbo].[Attendance] ([scheduleId], [idsv], [createdDate], [updatedDate], [status], [note]) VALUES (4, N'B8867', CAST(N'2021-01-20 13:51:02.737' AS DateTime), CAST(N'2021-01-20 15:33:02.777' AS DateTime), N'PA', NULL)
INSERT [dbo].[Attendance] ([scheduleId], [idsv], [createdDate], [updatedDate], [status], [note]) VALUES (4, N'B8874', CAST(N'2021-01-20 13:51:03.063' AS DateTime), CAST(N'2021-01-20 15:33:02.827' AS DateTime), N'P', N'không  làm bài tập')
INSERT [dbo].[Class] ([lop], [idFaculty], [idCourse]) VALUES (N'C1882I4', 3, N'K60')
INSERT [dbo].[Class] ([lop], [idFaculty], [idCourse]) VALUES (N'C19082', 2, N'M02')
INSERT [dbo].[Class] ([lop], [idFaculty], [idCourse]) VALUES (N'C1908i1', 2, N'M01')
INSERT [dbo].[Class] ([lop], [idFaculty], [idCourse]) VALUES (N'C1909i1', 1, N'M01')
INSERT [dbo].[Class] ([lop], [idFaculty], [idCourse]) VALUES (N'C1909i2', 1, N'M01')
INSERT [dbo].[Class] ([lop], [idFaculty], [idCourse]) VALUES (N'C1909I3', 2, N'M02')
INSERT [dbo].[Course] ([maCourse], [startDate], [endDate]) VALUES (N'K60', CAST(N'2016-10-18' AS Date), CAST(N'2020-10-21' AS Date))
INSERT [dbo].[Course] ([maCourse], [startDate], [endDate]) VALUES (N'M01', CAST(N'2021-01-13' AS Date), CAST(N'2021-01-14' AS Date))
INSERT [dbo].[Course] ([maCourse], [startDate], [endDate]) VALUES (N'M02', CAST(N'2021-01-10' AS Date), CAST(N'2021-01-20' AS Date))
SET IDENTITY_INSERT [dbo].[Faculty] ON 

INSERT [dbo].[Faculty] ([id], [khoa], [year]) VALUES (1, N'Công Nghệ Thông Tin', 2012)
INSERT [dbo].[Faculty] ([id], [khoa], [year]) VALUES (2, N'Quản trị kinh doanh', 2013)
INSERT [dbo].[Faculty] ([id], [khoa], [year]) VALUES (3, N'Marketing', 2011)
INSERT [dbo].[Faculty] ([id], [khoa], [year]) VALUES (4, N'Y Đa Khoa', 2010)
SET IDENTITY_INSERT [dbo].[Faculty] OFF
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8800', 2, 3, 1, 1, N'Không Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8800', 2, 5, 2, 1, N'Không Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8800', 2, 6, 3, 1, N'Học lại')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8800', 3, 12, 1, 1, N'Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8800', 4, 15, 1, 1, N'Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8800', 4, 8, 1, 2, N'Không Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8800', 4, 8, 2, 2, N'Không Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8833', 1, 1, 1, 1, N'Không Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8833', 1, 15, 1, 2, N'Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8833', 1, 12, 2, 1, N'Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8834', 5, 12, 1, 1, N'Đạt')
INSERT [dbo].[Mark] ([idsv], [idmon], [diem], [lanthi], [type], [ketqua]) VALUES (N'B8867', 4, 8, 2, 2, N'Không Đạt')
SET IDENTITY_INSERT [dbo].[Mark_type] ON 

INSERT [dbo].[Mark_type] ([id], [name]) VALUES (1, N'Thực Hành')
INSERT [dbo].[Mark_type] ([id], [name]) VALUES (2, N'Lý Thuyết')
SET IDENTITY_INSERT [dbo].[Mark_type] OFF
SET IDENTITY_INSERT [dbo].[schedule] ON 

INSERT [dbo].[schedule] ([Id], [subjectId], [teacherId], [classId], [frameTime], [startTime], [endTime], [startDate], [endDate], [note]) VALUES (1, 1, 3, N'C1909i1', 1, CAST(N'13:30:00' AS Time), CAST(N'15:30:00' AS Time), CAST(N'2020-11-03' AS Date), CAST(N'2021-01-03' AS Date), N'')
INSERT [dbo].[schedule] ([Id], [subjectId], [teacherId], [classId], [frameTime], [startTime], [endTime], [startDate], [endDate], [note]) VALUES (3, 7, 2, N'C19082', 0, CAST(N'12:30:00' AS Time), CAST(N'15:00:00' AS Time), CAST(N'2020-07-24' AS Date), CAST(N'2020-08-14' AS Date), N'')
INSERT [dbo].[schedule] ([Id], [subjectId], [teacherId], [classId], [frameTime], [startTime], [endTime], [startDate], [endDate], [note]) VALUES (4, 6, 1, N'C1909i2', 0, CAST(N'10:30:00' AS Time), CAST(N'17:30:00' AS Time), CAST(N'2021-01-01' AS Date), CAST(N'2021-03-12' AS Date), N'')
INSERT [dbo].[schedule] ([Id], [subjectId], [teacherId], [classId], [frameTime], [startTime], [endTime], [startDate], [endDate], [note]) VALUES (5, 4, 2, N'C1909I3', 0, CAST(N'15:30:00' AS Time), CAST(N'17:30:00' AS Time), CAST(N'2021-01-02' AS Date), CAST(N'2021-03-10' AS Date), N'kiểm tra')
INSERT [dbo].[schedule] ([Id], [subjectId], [teacherId], [classId], [frameTime], [startTime], [endTime], [startDate], [endDate], [note]) VALUES (6, 3, 3, N'C1908i1', 0, CAST(N'15:30:00' AS Time), CAST(N'17:30:00' AS Time), CAST(N'2021-01-07' AS Date), CAST(N'2021-03-17' AS Date), N'')
SET IDENTITY_INSERT [dbo].[schedule] OFF
INSERT [dbo].[Sem] ([idFaculty], [idmon], [year], [sem], [soTinchi]) VALUES (1, 1, 2020, 2, 10)
INSERT [dbo].[Sem] ([idFaculty], [idmon], [year], [sem], [soTinchi]) VALUES (1, 3, 2019, 1, 10)
INSERT [dbo].[Sem] ([idFaculty], [idmon], [year], [sem], [soTinchi]) VALUES (2, 5, 2020, 2, 15)
INSERT [dbo].[Sem] ([idFaculty], [idmon], [year], [sem], [soTinchi]) VALUES (2, 6, 2017, 2, 10)
INSERT [dbo].[Sem] ([idFaculty], [idmon], [year], [sem], [soTinchi]) VALUES (2, 7, 2016, 1, 15)
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B0001', N'Đặng Thùy Trâm', CAST(N'1999-01-05' AS Date), N'0911224455', N'tram@gmail.com', N'Ninh Bình', 1, N'C1909I3')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B0002', N'Nguyễn Văn Nghĩa', CAST(N'1999-03-08' AS Date), N'0997766553', N'nghia@gmail.com', N'Bình Phước', 1, N'C1909i1')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B5634', N'Vũ Hằng', CAST(N'2018-11-08' AS Date), N'0953478683', N'hangbeo@gmail.com', N'Giao Thủy', 0, N'C1909I3')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B6765', N'Nguyễn Minh Tuyết', CAST(N'2008-05-13' AS Date), N'0975673562', N'tuyet@gmail.com', N'Hải Phòng', 1, N'C19082')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B7656', N'Hoàng Quốc Việt', CAST(N'2002-06-07' AS Date), N'0988775555', N'viet@gmail.com', N'Thái Nguyên', 0, N'C1909I3')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8432', N'Trần Thị Hà', CAST(N'2001-06-14' AS Date), N'0976824561', N'ha@gmail.com', N'Quảng Ninh', 0, N'C1909i1')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8797', N'Đào Văn Cao', CAST(N'2021-01-04' AS Date), N'0987343456', N'cao@gmail.com', N'Hòa Bình', 0, N'C1909i2')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8798', N'Nguyễn Thái Nhật Hoàng', CAST(N'2021-01-04' AS Date), N'0987654321', N'hoang@gmail.com', N'Thái Bình', 1, N'C1908i1')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8800', N'Đức Hạnh', CAST(N'2021-01-07' AS Date), N'0998762232', N'hanhbo@gmail.com', N'Quảng Ninh', 1, N'C19082')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8802', N'Đức Phúc', CAST(N'2003-01-05' AS Date), N'0886677856', N'ducphuc@gmail.com', N'Đà Lạt', 1, N'C1909i1')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8833', N'Phạm Thị Duyên', CAST(N'2021-01-21' AS Date), N'0989877654', N'pham@gmail.com', N'Thái Bình', 0, N'C1909i1')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8834', N'Quang Long', CAST(N'2021-01-07' AS Date), N'0938237283', N'ahaha@gmail.com', N'Ninh Bình', 0, N'C1908i1')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8845', N'Hoàng Minh Tuấn', CAST(N'2021-01-05' AS Date), N'0987234567', N'tuan@gmail.com', N'Thái Bình', 1, N'C1908i1')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8867', N'Tiến Đạt', CAST(N'2015-06-19' AS Date), N'0988932568', N'ahihi@gmail.com', N'Nam Định', 1, N'C1909i2')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B8874', N'Quang Đạt', CAST(N'2018-05-15' AS Date), N'0932378273', N'ahoho@gmail.com', N'Nam Định', 1, N'C1909i2')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B9900', N'Phạm Hòng Nhung', CAST(N'2003-05-14' AS Date), N'0997766554', N'nhung@gmail.com', N'Đà Nẵng', 1, N'C1909i2')
INSERT [dbo].[Student] ([idsv], [hoten], [ngaysinh], [phone], [email], [diachi], [gioitinh], [idlop]) VALUES (N'B9908', N'Vũ Thị Hoài', CAST(N'2004-01-04' AS Date), N'0983466778', N'hoai@gmail.com', N'Nghệ An', 1, N'C1909i2')
SET IDENTITY_INSERT [dbo].[Subject] ON 

INSERT [dbo].[Subject] ([id], [mon], [idFaculty]) VALUES (1, N'Java', 1)
INSERT [dbo].[Subject] ([id], [mon], [idFaculty]) VALUES (2, N'HTML', 1)
INSERT [dbo].[Subject] ([id], [mon], [idFaculty]) VALUES (3, N'C++', 1)
INSERT [dbo].[Subject] ([id], [mon], [idFaculty]) VALUES (4, N'PHP', 1)
INSERT [dbo].[Subject] ([id], [mon], [idFaculty]) VALUES (5, N'An ninh mang', 2)
INSERT [dbo].[Subject] ([id], [mon], [idFaculty]) VALUES (6, N'Toán cao cấp', 2)
INSERT [dbo].[Subject] ([id], [mon], [idFaculty]) VALUES (7, N'Phân tích thị trường', 2)
SET IDENTITY_INSERT [dbo].[Subject] OFF
SET IDENTITY_INSERT [dbo].[Teacher] ON 

INSERT [dbo].[Teacher] ([idgv], [hoten], [phone], [email], [gender], [ngaysinh]) VALUES (1, N'Lê Thành', N'0983132355', N'lethanh@gmail.com', 1, CAST(N'2020-01-20' AS Date))
INSERT [dbo].[Teacher] ([idgv], [hoten], [phone], [email], [gender], [ngaysinh]) VALUES (2, N'Phạm Duyên', N'098764432', N'phamduyentba@gmail.com', 0, CAST(N'2021-01-21' AS Date))
INSERT [dbo].[Teacher] ([idgv], [hoten], [phone], [email], [gender], [ngaysinh]) VALUES (3, N'Văn Quyết', N'0956477235', N'quyetcoi@gmail.com', 1, CAST(N'2021-05-14' AS Date))
INSERT [dbo].[Teacher] ([idgv], [hoten], [phone], [email], [gender], [ngaysinh]) VALUES (4, N'Trần Văn Ninh', N'0988756231', N'ninh@gmail.com', 1, CAST(N'1995-01-17' AS Date))
INSERT [dbo].[Teacher] ([idgv], [hoten], [phone], [email], [gender], [ngaysinh]) VALUES (5, N'Nguyễn Văn Lương', N'0976453211', N'luong@gmail.com', 1, CAST(N'1999-01-05' AS Date))
INSERT [dbo].[Teacher] ([idgv], [hoten], [phone], [email], [gender], [ngaysinh]) VALUES (6, N'Phạm Văn Đồng', N'0988442456', N'dong@gmail.com', 1, CAST(N'1987-01-05' AS Date))
INSERT [dbo].[Teacher] ([idgv], [hoten], [phone], [email], [gender], [ngaysinh]) VALUES (7, N'Trần Qúy Kiên', N'0988764453', N'kien@gmail.com', 0, CAST(N'1997-01-05' AS Date))
SET IDENTITY_INSERT [dbo].[Teacher] OFF
INSERT [dbo].[Teacher_Class] ([idgv], [idClass]) VALUES (1, N'C1908i1')
INSERT [dbo].[Teacher_Class] ([idgv], [idClass]) VALUES (1, N'C1909i1')
INSERT [dbo].[Teacher_Class] ([idgv], [idClass]) VALUES (2, N'C19082')
INSERT [dbo].[Teacher_Class] ([idgv], [idClass]) VALUES (2, N'C1909i2')
INSERT [dbo].[Teacher_Class] ([idgv], [idClass]) VALUES (5, N'C1909I3')
INSERT [dbo].[Teacher_Class] ([idgv], [idClass]) VALUES (6, N'C1908i1')
INSERT [dbo].[Teacher_Class] ([idgv], [idClass]) VALUES (6, N'C1909i1')
INSERT [dbo].[Teacher_Class] ([idgv], [idClass]) VALUES (7, N'C19082')
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (1, 1)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (1, 2)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (2, 1)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (2, 3)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (2, 4)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (2, 5)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (2, 6)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (3, 5)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (4, 7)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (5, 6)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (6, 3)
INSERT [dbo].[Teacher_Subject] ([idgv], [idsb]) VALUES (7, 2)
ALTER TABLE [dbo].[Attendance]  WITH CHECK ADD FOREIGN KEY([scheduleId])
REFERENCES [dbo].[schedule] ([Id])
GO
ALTER TABLE [dbo].[Attendance]  WITH CHECK ADD FOREIGN KEY([idsv])
REFERENCES [dbo].[Student] ([idsv])
GO
ALTER TABLE [dbo].[Class]  WITH CHECK ADD FOREIGN KEY([idCourse])
REFERENCES [dbo].[Course] ([maCourse])
GO
ALTER TABLE [dbo].[Class]  WITH CHECK ADD FOREIGN KEY([idFaculty])
REFERENCES [dbo].[Faculty] ([id])
GO
ALTER TABLE [dbo].[Mark]  WITH CHECK ADD FOREIGN KEY([idmon])
REFERENCES [dbo].[Subject] ([id])
GO
ALTER TABLE [dbo].[Mark]  WITH CHECK ADD FOREIGN KEY([idsv])
REFERENCES [dbo].[Student] ([idsv])
GO
ALTER TABLE [dbo].[Mark]  WITH CHECK ADD FOREIGN KEY([type])
REFERENCES [dbo].[Mark_type] ([id])
GO
ALTER TABLE [dbo].[schedule]  WITH CHECK ADD FOREIGN KEY([classId])
REFERENCES [dbo].[Class] ([lop])
GO
ALTER TABLE [dbo].[schedule]  WITH CHECK ADD FOREIGN KEY([subjectId])
REFERENCES [dbo].[Subject] ([id])
GO
ALTER TABLE [dbo].[schedule]  WITH CHECK ADD FOREIGN KEY([teacherId])
REFERENCES [dbo].[Teacher] ([idgv])
GO
ALTER TABLE [dbo].[Sem]  WITH CHECK ADD FOREIGN KEY([idFaculty])
REFERENCES [dbo].[Faculty] ([id])
GO
ALTER TABLE [dbo].[Sem]  WITH CHECK ADD FOREIGN KEY([idmon])
REFERENCES [dbo].[Subject] ([id])
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD FOREIGN KEY([idlop])
REFERENCES [dbo].[Class] ([lop])
GO
ALTER TABLE [dbo].[Subject]  WITH CHECK ADD FOREIGN KEY([idFaculty])
REFERENCES [dbo].[Faculty] ([id])
GO
ALTER TABLE [dbo].[Teacher_Class]  WITH CHECK ADD FOREIGN KEY([idClass])
REFERENCES [dbo].[Class] ([lop])
GO
ALTER TABLE [dbo].[Teacher_Class]  WITH CHECK ADD FOREIGN KEY([idgv])
REFERENCES [dbo].[Teacher] ([idgv])
GO
ALTER TABLE [dbo].[Teacher_Subject]  WITH CHECK ADD FOREIGN KEY([idgv])
REFERENCES [dbo].[Teacher] ([idgv])
GO
ALTER TABLE [dbo].[Teacher_Subject]  WITH CHECK ADD FOREIGN KEY([idsb])
REFERENCES [dbo].[Subject] ([id])
GO
/****** Object:  StoredProcedure [dbo].[addUser]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[addUser]
	@ten nvarchar(200),
   @password nvarchar(100),
   @rone nvarchar(200)
as
begin
	insert into Admin(ten,password,role) values(@ten,@password,@rone)
end


GO
/****** Object:  StoredProcedure [dbo].[getInfoStudent]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getInfoStudent]
	@lop nvarchar(8)
as
begin
	select
		c.lop as 'className',
		std.idsv,
		std.hoten as 'studentName'
	from Student std
	join Class c on std.idlop = c.lop
	where c.lop = @lop
end

GO
/****** Object:  StoredProcedure [dbo].[sp_addAttendance]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_addAttendance]
	@scheduleId int ,
	@idsv nvarchar(8),
	@createdDate datetime,
	@updatedDate datetime,
	@status nvarchar(10),
	@note nvarchar(255)
as
begin
	insert into Attendance (scheduleId,idsv,createdDate,updatedDate,[status],note) values (@scheduleId,@idsv,@createdDate,@updatedDate,@status,@note)
end
GO
/****** Object:  StoredProcedure [dbo].[sp_addClass]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_addClass]
	@lop nvarchar(20),
	@faculty int,
	@course nvarchar(20)
as
begin
	insert into Class(lop,idFaculty,idCourse) values (@lop,@faculty,@course)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_addCourse]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_addCourse]
	@ma nvarchar(20),
	@startDate date,
	@endDate date
as
begin
	insert into Course(maCourse,startDate,endDate) values (@ma,@startDate,@endDate)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_addFaculty]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_addFaculty]
	@khoa nvarchar(200),
	@year int
as
begin
	insert into Faculty(khoa,year) values (@khoa,@year)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_addSchedule]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_addSchedule]
	@subjectId int,
	@teacherId int,
	@classId nvarchar(20),
	@frameTime bit,
	@startTime Time,
	@endTime Time,
	@startDate date,
	@endDate date,
	@note nvarchar(255)
as
begin
	insert into schedule(subjectId,teacherId,classId,frameTime,startTime,endTime,startDate,endDate,note) values (@subjectId,@teacherId,@classId,@frameTime,@startTime,@endTime,@startDate,@endDate,@note)
end

GO
/****** Object:  StoredProcedure [dbo].[sp_countClass]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_countClass]
as
begin
     Select count(*) as 'countClass' from Class
end


GO
/****** Object:  StoredProcedure [dbo].[sp_countCourse]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_countCourse]
as
begin
     Select count(*) as 'countCourse' from Course
end


GO
/****** Object:  StoredProcedure [dbo].[sp_countSubject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_countSubject]
as
begin
     Select count(*) as 'countSubject' from Subject
end


GO
/****** Object:  StoredProcedure [dbo].[sp_countTeacher]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_countTeacher]
as
begin
     Select count(*) as 'countTeacher' from Teacher
end

GO
/****** Object:  StoredProcedure [dbo].[sp_countUser]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_countUser]
as
begin
     Select count(*) as 'countUser' from Admin
end


GO
/****** Object:  StoredProcedure [dbo].[sp_coutStudent]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_coutStudent]
as
begin 
    Select count(*) as 'countStudent' from Student 
end


GO
/****** Object:  StoredProcedure [dbo].[sp_deleteMark_Type]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_deleteMark_Type]
   @id int
as
begin 
   Delete from Mark_type where id=@id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_deleteSchedule]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_deleteSchedule]
	@id int
as
begin
	delete from schedule where Id = @id
end

GO
/****** Object:  StoredProcedure [dbo].[sp_deleteSem]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_deleteSem]
   @idmon int,
   @idFaculty int
as
begin
   Delete from Sem where idmon=@idmon and idFaculty=@idFaculty
end


GO
/****** Object:  StoredProcedure [dbo].[sp_deleteStudent]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_deleteStudent]
    @idsv nvarchar(8)
as
begin
    Delete from Student where idsv=@idsv
end


GO
/****** Object:  StoredProcedure [dbo].[sp_deleteSubject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_deleteSubject]
   @id int
as
begin
   Delete from Subject where id=@id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_deleteTeacher]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_deleteTeacher]
    @idgv int
as
begin
    Delete from Teacher where idgv=@idgv
end


GO
/****** Object:  StoredProcedure [dbo].[sp_deleteTeacher_Class]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_deleteTeacher_Class]
    @idgv int,
	@idClass nvarchar(8)
as
begin
   Delete from Teacher_Class where idgv=@idgv and idClass = @idClass
end


GO
/****** Object:  StoredProcedure [dbo].[sp_deleteTeacher_Subject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_deleteTeacher_Subject]
    @idgv int,
	@idSbj int
as
begin
   Delete from Teacher_Subject where idgv=@idgv and idsb = @idSbj
end


GO
/****** Object:  StoredProcedure [dbo].[sp_editAttendance]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_editAttendance]
	@idchedule int,
	@currentDate date
as
begin
	select 
		a.*,
		std.hoten
	from Attendance a
	join Student std on std.idsv = a.idsv
	where a.scheduleId = @idchedule
	and a.createdDate >= @currentDate
end

GO
/****** Object:  StoredProcedure [dbo].[sp_editClass]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_editClass]
	@lop nvarchar(20),
	@faculty int,
	@course nvarchar(20)
as
begin
	update Class set idFaculty = @faculty,idCourse = @course where lop = @lop
end


GO
/****** Object:  StoredProcedure [dbo].[sp_editCourse]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_editCourse]
	@ma nvarchar(20),
	@startDate date,
	@endDate date
as
begin
	update Course set startDate = @startDate,endDate = @endDate where maCourse = @ma
end


GO
/****** Object:  StoredProcedure [dbo].[sp_editFaculty]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_editFaculty]
	@id int,
	@khoa nvarchar(200),
	@year int
as
begin
	update Faculty set khoa = @khoa,year = @year where id = @id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_editUser]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_editUser]
	@id int,
	@ten nvarchar(200),
	@password nvarchar(100)
as
begin
	update Admin set ten = @ten,password=@password where id=@id
end



GO
/****** Object:  StoredProcedure [dbo].[sp_findMark]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


Create proc [dbo].[sp_findMark]
   @idsv nvarchar(200),
   @idmon nvarchar(200),
   @type nvarchar(200),
   @lanthi int
as
begin
    Select st.idsv as 'id_sv',sb.mon as 'mon',st.hoten as 'name',mt.name as 'type_mark',st.idlop as 'lop',m.* 
	from Mark m
join Student st on m.idsv=st.idsv
join Subject sb on m.idmon=sb.id
join Mark_type mt on m.type=mt.id
where  st.idsv=@idsv and sb.mon=@idmon and mt.name=@type and m.lanthi=@lanthi
end


GO
/****** Object:  StoredProcedure [dbo].[sp_findMark_Type]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_findMark_Type]
     @id int 
as
begin
    Select *from Mark_type where id=@id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_findSchedule]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_findSchedule]
	@id int
as
begin
	select
		sbj.mon,
		c.lop,
		t.hoten,
		s.*
	from schedule s
	join Subject sbj on sbj.id = s.subjectId
	join Teacher t on t.idgv = s.teacherId
	join Class c on c.lop = s.classId
	where s.Id = @id
end
GO
/****** Object:  StoredProcedure [dbo].[sp_findSem]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_findSem]
    @idmon nvarchar(200),
	@idFaculty nvarchar(200)
as
begin
    Select f.khoa as 'name_Faculty',sb.mon as 'name_mon',s.* from Sem s join Faculty f on s.idFaculty=f.id join Subject sb on s.idmon=sb.id where sb.mon=@idmon and f.khoa=@idFaculty
end


GO
/****** Object:  StoredProcedure [dbo].[sp_findStudent]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_findStudent]
     @idsv nvarchar(8)
as
begin
    Select *from Student where idsv=@idsv
end


GO
/****** Object:  StoredProcedure [dbo].[sp_findSubject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_findSubject]
    @id int
as
begin
    Select * from Subject 
	where id=@id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_findTeacher]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_findTeacher]
     @idgv int
as
begin
    Select *from Teacher where idgv=@idgv
end


GO
/****** Object:  StoredProcedure [dbo].[sp_findTeacher_Class]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_findTeacher_Class]
    @idgv nvarchar(200),
	@idClass nvarchar(8)
as
begin
   select tc.*,t.hoten as 'nameGV',c.lop as 'nameClass'
   from Teacher_Class tc 
	join Teacher t on tc.idgv=t.idgv 
	join Class c on tc.idClass=c.lop 
	where t.hoten=@idgv and c.lop = @idClass
end



GO
/****** Object:  StoredProcedure [dbo].[sp_findTeacher_Subject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_findTeacher_Subject]
    @idgv nvarchar(200),
	@idSbj nvarchar(200)
as
begin
   select ts.* ,t.hoten as 'nameGV',sj.mon as 'nameSbj'
   from Teacher_Subject ts
	join Teacher t on ts.idgv=t.idgv 
	join Subject sj on sj.id=ts.idsb 
   where t.hoten=@idgv and sj.mon = @idSbj
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getAdmin]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_getAdmin]
as
begin
	select*from Admin
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getClass]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--table Class
create proc [dbo].[sp_getClass]
as
begin
	select c.* , f.khoa as 'khoa'
	from Class c
	join Faculty f on c.idFaculty = f.id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getClassSearch]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_getClassSearch]
as 
begin 
    select c.lop as 'className',f.khoa as 'Faculty_Name',co.maCourse as 'course',count(f.khoa)as 'khoa',count(co.maCourse) as 'ma'
	from Class c
	join Faculty f on c.idFaculty = f.id
	join Course co on c.idCourse = co.maCourse
	Group by c.lop ,f.khoa,co.maCourse
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getCourse]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_getCourse]
as
begin
	select * from Course
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getFaculty]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- table Faculty
create proc [dbo].[sp_getFaculty]
as
begin
	select * from Faculty
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getFacultySearch]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_getFacultySearch]
as
begin
    Select f.id,f.khoa,f.year,count(c.idFaculty) as 'number_Teacher' from Faculty f
	left join Class c on f.id=c.idFaculty
	Group by f.id,f.khoa,f.year,c.idFaculty
end
GO
/****** Object:  StoredProcedure [dbo].[sp_getFCourse]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_getFCourse]
	@ma nvarchar(20)
as
begin
	select * from Course where maCourse = @ma 
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getfindAdmin]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getfindAdmin]
	@id int
as
begin
	select * from Admin where id=@id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getfindAdminAll]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_getfindAdminAll]
	@ten nvarchar(200)
as
begin
	select * from Admin where ten LIKE N'%'+@ten+'%'
end



GO
/****** Object:  StoredProcedure [dbo].[sp_getFindAllClass]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_getFindAllClass]
	@lop nvarchar(20)
as
begin
	select c.* , f.khoa as 'khoa'
	from Class c
	join Faculty f on c.idFaculty = f.id
	where lop LIKE N'%'+@lop+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getFindAllFaculty]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_getFindAllFaculty]
	@khoa nvarchar(200)
as
begin
	select * from Faculty where khoa LIKE N'%'+@khoa+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getFindClass]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_getFindClass]
	@lop nvarchar(20)
as
begin
	select * from Class where lop = @lop
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getFindCourse]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


create proc [dbo].[sp_getFindCourse]
	@ma nvarchar(20)
as
begin
	select * from Course where maCourse LIKE N'%'+@ma+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getFindFaculty]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_getFindFaculty]
	@id int
as
begin
	select * from Faculty where id = @id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getFUser]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_getFUser]
	@ma int
as
begin
	select * from Admin where id = @ma
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getListSchedule]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getListSchedule]
	@search nvarchar(255)
as
begin
	select
		sbj.mon,
		c.lop,
		t.hoten,
		s.*
	from schedule s
	join Subject sbj on sbj.id = s.subjectId
	join Teacher t on t.idgv = s.teacherId
	join Class c on c.lop = s.classId
	where (sbj.mon like  N'%'+@search+'%' or t.hoten like  N'%'+@search+'%' or c.lop like  N'%'+@search+'%')
end
GO
/****** Object:  StoredProcedure [dbo].[sp_getMakeCountKQ]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getMakeCountKQ]
	@idsv nvarchar(8),
	@kq nvarchar(20)
as
begin
select mk.ketqua, COUNT(mk.ketqua) as 'count'
	from Mark mk
	join Subject sbj on sbj.id = mk.idmon
	join Mark_type mt on mt.id = mk.type
	where mk.idsv = @idsv 
	and sbj.id=mk.idmon
	and mk.type = mt.id
	and mk.ketqua = @kq
	and mk.lanthi = (select max(ccc.lanthi) from (
	select mk.lanthi
	from Mark mk
	where mk.idsv =@idsv and sbj.id=mk.idmon and mk.type = mt.id) as ccc)
	group by mk.ketqua
end
GO
/****** Object:  StoredProcedure [dbo].[sp_getMakeStatistical]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_getMakeStatistical]
	@idsv nvarchar(8)
as
begin
	select mk.diem,mk.idmon,mk.idsv,mk.ketqua,mk.lanthi,mk.type,sbj.mon,mt.name as 'type_name'
	from Mark mk
	join Subject sbj on sbj.id = mk.idmon
	join Mark_type mt on mt.id = mk.type
	where mk.idsv = @idsv 
	and sbj.id=mk.idmon
	and mk.type = mt.id
	and mk.lanthi = (select max(ccc.lanthi) from (
	select mk.lanthi
	from Mark mk
	where mk.idsv =@idsv and sbj.id=mk.idmon and mk.type = mt.id) as ccc)
end
GO
/****** Object:  StoredProcedure [dbo].[sp_getMark]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--table Mark
Create proc [dbo].[sp_getMark]
as
begin
    Select st.idsv as 'id_sv',sb.mon as 'mon',st.hoten as 'name',mt.name as 'type_mark',st.idlop as 'lop',m.* from Mark m
join Student st on m.idsv=st.idsv
join Subject sb on m.idmon=sb.id
join Mark_type mt on m.type=mt.id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getMarkType]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_getMarkType]
as
begin
   Select *from Mark_type
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getScheduleToday]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getScheduleToday]
	@frameTime bit,
	@currentTime Time,
	@currentDate date
as
begin
	select
		sbj.mon,
		c.lop,
		t.hoten,
		s.*
	from schedule s
	join Subject sbj on sbj.id = s.subjectId
	join Teacher t on t.idgv = s.teacherId
	join Class c on c.lop = s.classId
	where s.frameTime = @frameTime
	and @currentDate BETWEEN s.startDate AND s.endDate
	and @currentTime BETWEEN s.startTime AND s.endTime
end

GO
/****** Object:  StoredProcedure [dbo].[sp_getSeeMark]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_getSeeMark]
as
begin
   Select f.khoa as 'idFaculty',t.hoten as 'ten',st.idlop as 'lop', st.idsv as 'id_sv',sb.mon as 'mon',st.hoten as 'name',mt.name as 'type_mark',m.* from Mark m
join Student st on m.idsv=st.idsv
join Subject sb on m.idmon=sb.id
join Mark_type mt on m.type=mt.id
join Teacher_Subject ts on sb.id=ts.idsb
join Teacher t on ts.idgv=t.idgv
join Faculty f on sb.idFaculty=f.id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getSeeMarkSortByASC]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_getSeeMarkSortByASC]
as
begin
   Select f.khoa as 'idFaculty',t.hoten as 'ten',st.idlop as 'lop', st.idsv as 'id_sv',sb.mon as 'mon',st.hoten as 'name',mt.name as 'type_mark',m.* from Mark m
join Student st on m.idsv=st.idsv
join Subject sb on m.idmon=sb.id
join Mark_type mt on m.type=mt.id
join Teacher_Subject ts on sb.id=ts.idsb
join Teacher t on ts.idgv=t.idgv
join Faculty f on sb.idFaculty=f.id
order by st.hoten ASC
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getSeeMarkSortByDESC]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_getSeeMarkSortByDESC]
as
begin
   Select f.khoa as 'idFaculty',t.hoten as 'ten',st.idlop as 'lop', st.idsv as 'id_sv',sb.mon as 'mon',st.hoten as 'name',mt.name as 'type_mark',m.* from Mark m
join Student st on m.idsv=st.idsv
join Subject sb on m.idmon=sb.id
join Mark_type mt on m.type=mt.id
join Teacher_Subject ts on sb.id=ts.idsb
join Teacher t on ts.idgv=t.idgv
join Faculty f on sb.idFaculty=f.id
order by st.hoten DESC
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getSem]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--Table Lectuer
Create proc [dbo].[sp_getSem]
as
begin 
   Select f.khoa as 'name_Faculty',sb.mon as 'name_mon',s.*  from Sem s join Faculty f on s.idFaculty=f.id join Subject sb on s.idmon=sb.id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getStudent]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--Table Student

Create proc [dbo].[sp_getStudent]
as
begin
    Select std.*,c.lop as 'class'
	from Student std
	join Class c on std.idlop = c.lop
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getSubject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--table Subject

Create proc [dbo].[sp_getSubject]
as
begin 
   Select sb.id,sb.mon,f.khoa as 'ten_Faculty' 
   from Subject sb join Faculty f on sb.idFaculty=f.id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getSubjectSearch]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_getSubjectSearch]
as
begin 
   Select sb.id,sb.mon,f.khoa as 'ten_Faculty', count(ts.idgv) as 'number'
   from Subject sb join Faculty f on sb.idFaculty=f.id
   join Teacher_Subject ts on sb.id=ts.idsb
   Group by sb.id,sb.mon,f.khoa ,ts.idgv
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getTeacher]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_getTeacher]
as
begin
    Select *from Teacher
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getTeacher_Class]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Table Teacher_Class

Create proc [dbo].[sp_getTeacher_Class]
as
begin
    Select t.idgv,t.hoten as'name_gv',c.lop as'name_Class' 
	from Teacher_Class tc 
	join Teacher t on tc.idgv=t.idgv 
	join Class c on tc.idClass=c.lop
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getTeacher_Subject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



--table Teacher_Subject
create proc [dbo].[sp_getTeacher_Subject]
as
begin
    Select t.idgv,t.hoten as'name_gv',sj.mon as'name_Subject' ,sj.id as 'idSubject'
	from Teacher_Subject ts
	join Teacher t on ts.idgv=t.idgv 
	join Subject sj on sj.id=ts.idsb
end


GO
/****** Object:  StoredProcedure [dbo].[sp_getTeacherSearch]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_getTeacherSearch]
as
begin
    Select t.idgv,t.email,t.gender,t.hoten,t.ngaysinh,t.phone,count(tc.idgv) as 'number_Class' from Teacher t
	join Teacher_Class tc on t.idgv=tc.idgv
	GROUP BY t.idgv,t.email,t.gender,t.hoten,t.ngaysinh,t.phone
end
GO
/****** Object:  StoredProcedure [dbo].[sp_insertMark]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_insertMark]
   @idsv nvarchar(200),
   @idmon int,
   @type int,
   @diem float,
   @lanthi int,
   @ketqua nvarchar(200)
as
begin
    Insert into Mark(idsv,idmon,type,diem,lanthi,ketqua) values(@idsv,@idmon,@type,@diem,@lanthi,@ketqua)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_insertMarkType]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_insertMarkType]
  @name nvarchar(200)
as
begin
   Insert into Mark_type(name) values(@name)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_insertSem]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_insertSem]
	@idFaculty int ,
	@idmon int,
	@sem int,
	@year int,
	@soTinchi int
as
begin 
   Insert into Sem(idFaculty,idmon,sem,year,soTinchi) values(@idFaculty,@idmon,@sem,@year,@soTinchi)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_insertStudent]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_insertStudent]
	@idsv nvarchar(8),
	@hoten nvarchar(200),
	@ngaysinh date,
	@phone nvarchar(11),
	@email nvarchar(200),
	@diachi nvarchar(200),
	@gioitinh bit,
	@idlop nvarchar(20)
as
begin 
    Insert into Student(idsv,hoten,ngaysinh,phone,email,diachi,gioitinh,idlop) values(@idsv,@hoten,@ngaysinh,@phone,@email,@diachi,@gioitinh,@idlop)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_insertSubject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_insertSubject]
   @mon nvarchar(200),
   @idFaculty int
as
begin 
   Insert into Subject(mon,idFaculty) values(@mon,@idFaculty)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_insertTeacher]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_insertTeacher]
	@hoten nvarchar(200),
	@phone nvarchar(11),
	@email nvarchar(100),
	@gender bit,
	@ngaysinh date
as
begin 
    Insert into Teacher(hoten,phone,email,gender,ngaysinh) values(@hoten,@phone,@email,@gender,@ngaysinh)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_insertTeacher_Class]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_insertTeacher_Class]
    @idgv int,
	@idClass nvarchar(200)
as
begin
   Insert into Teacher_Class(idgv,idClass) values(@idgv,@idClass)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_insertTeacher_Subject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_insertTeacher_Subject]
    @idgv int,
	@idsb nvarchar(200)
as
begin
   Insert into Teacher_Subject(idgv,idsb) values(@idgv,@idsb)
end


GO
/****** Object:  StoredProcedure [dbo].[sp_login]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_login]
	@ten nvarchar(200),
	@password nvarchar(100)
as
begin
	select * from Admin where ten = @ten and password = @password
end



GO
/****** Object:  StoredProcedure [dbo].[sp_removeClass]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_removeClass]
	@lop nvarchar(20)
as
begin
	delete from Class where lop = @lop
end


GO
/****** Object:  StoredProcedure [dbo].[sp_removeCourse]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_removeCourse]
	@ma nvarchar(20)
as
begin
	delete from Course where maCourse = @ma 
end


GO
/****** Object:  StoredProcedure [dbo].[sp_removeFaculty]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_removeFaculty]
	@id int
as
begin
	delete from Faculty where id = @id 
end


GO
/****** Object:  StoredProcedure [dbo].[sp_removeUser]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_removeUser]
	@id int
as
begin
	delete from Admin where id=@id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_seacherSem]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_seacherSem]
   @idmon nvarchar(200)
as
begin 
   Select f.khoa as 'name_Faculty',sb.mon as 'name_mon',s.*  from Sem s join Faculty f on s.idFaculty=f.id join Subject sb on s.idmon=sb.id where sb.mon like N'%'+@idmon+'%' or f.khoa like N'%'+@idmon+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_seacherSubject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_seacherSubject]
   @mon nvarchar(200)
as
begin 
   Select sb.id,sb.mon,f.khoa as 'ten_Faculty' 
   from Subject sb join Faculty f on sb.idFaculty=f.id where sb.mon like N'%'+@mon+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_seacherTeacher_Class]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_seacherTeacher_Class]
   @idClass nvarchar(200)
as
begin
    Select t.idgv,t.hoten as'name_gv',c.lop as'name_Class' 
	from Teacher_Class tc 
	join Teacher t on tc.idgv=t.idgv 
	join Class c on tc.idClass=c.lop
	where c.lop like N'%'+@idClass+'%' OR t.hoten like N'%'+@idClass+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_seacherTeacher_Subject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_seacherTeacher_Subject]
   @idsb nvarchar(200)
as
begin
    Select t.idgv,t.hoten as'name_gv',sj.mon as'name_Subject' ,sj.id as 'idSubject'
	from Teacher_Subject ts
	join Teacher t on ts.idgv=t.idgv 
	join Subject sj on sj.id=ts.idsb  
	where sj.mon like N'%'+@idsb+'%' OR t.hoten LIKE N'%'+@idsb+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_Search_FacultySearch]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_Search_FacultySearch]
@name nvarchar(200)
as
begin
    Select f.id,f.khoa,f.year,count(c.idFaculty) as 'number_Teacher' from Faculty f
	left join Class c on f.id=c.idFaculty
	where f.khoa like N'%'+@name+'%' or f.year like N'%'+@name+'%'
	Group by f.id,f.khoa,f.year,c.idFaculty
end
GO
/****** Object:  StoredProcedure [dbo].[sp_Search_SubjectSearch]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_Search_SubjectSearch]
@name nvarchar(200)
as
begin 
   Select sb.id,sb.mon,f.khoa as 'ten_Faculty', count(ts.idgv) as 'number'
   from Subject sb join Faculty f on sb.idFaculty=f.id
   join Teacher_Subject ts on sb.id=ts.idsb
   where sb.mon  like N'%'+@name+'%' or f.khoa  like N'%'+@name+'%'
   Group by sb.id,sb.mon,f.khoa ,ts.idgv
end


GO
/****** Object:  StoredProcedure [dbo].[sp_SearchClassSearch]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_SearchClassSearch]
@name nvarchar(200)
as 
begin 
    select c.lop as 'className' ,f.khoa as 'Faculty_Name',co.maCourse as 'course',count(f.khoa)as 'khoa',count(co.maCourse) as 'ma'
	from Class c
	join Faculty f on c.idFaculty = f.id
	join Course co on c.idCourse = co.maCourse
	where c.lop like N'%'+@name+'%' or f.khoa like N'%'+@name+'%' or co.maCourse like N'%'+@name+'%'
	Group by c.lop ,f.khoa,co.maCourse
end

GO
/****** Object:  StoredProcedure [dbo].[sp_searchMark]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_searchMark]
   @search nvarchar(200)
as
begin
    Select st.idsv as 'id_sv',sb.mon as 'mon',st.hoten as 'name',mt.name as 'type_mark',st.idlop as 'lop',m.* from Mark m
join Student st on m.idsv=st.idsv
join Subject sb on m.idmon=sb.id
join Mark_type mt on m.type=mt.id
where m.idsv like N'%'+@search+'%'
or st.hoten like N'%'+@search+'%'
or sb.mon like N'%'+@search+'%'
or st.idlop like N'%'+@search+'%'
or m.ketqua like N'%'+@search+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_searchMark_Type]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_searchMark_Type]
   @name nvarchar(200)
as
begin
   Select *from Mark_type where name like N'%'+@name+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_SearchSeeMark]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_SearchSeeMark]
@idkhoa nvarchar(200),
@lop nvarchar(8),
@idSubject nvarchar(200),
@search nvarchar(200)
as
begin
	Select f.khoa as 'idFaculty',t.hoten as 'ten',st.idlop as 'lop', st.idsv as 'id_sv',sb.mon as 'mon',st.hoten as 'name',mt.name as 'type_mark',m.* from Mark m
	join Student st on m.idsv=st.idsv
	join Subject sb on m.idmon=sb.id
	join Mark_type mt on m.type=mt.id
	join Teacher_Subject ts on sb.id=ts.idsb
	join Teacher t on ts.idgv=t.idgv
	join Faculty f on sb.idFaculty=f.id
	where f.khoa=ISNULL(NULLIF(@idkhoa, null),f.khoa) 
		and st.idlop = ISNULL(NULLIF(@lop, null),st.idlop)
		and sb.mon = ISNULL(NULLIF(@idSubject, null),sb.mon)
		and (st.hoten like  N'%'+@search+'%' or t.hoten like  N'%'+@search+'%')
end

GO
/****** Object:  StoredProcedure [dbo].[sp_searchStudent]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[sp_searchStudent]
     @name nvarchar(200)
as
begin
   Select std.*,c.lop as 'class'
	from Student std
	join Class c on std.idlop = c.lop
	where std.hoten like N'%'+@name+'%' OR std.idsv like '%'+@name+'%' OR c.lop like '%'+@name+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_searchTeacher]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_searchTeacher]
     @name nvarchar(200)
as
begin
   Select *from Teacher where hoten like N'%'+@name+'%' or email like  N'%'+@name+'%' or phone like  N'%'+@name+'%'
end


GO
/****** Object:  StoredProcedure [dbo].[sp_SearchTeacherSearch]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_SearchTeacherSearch]
@name nvarchar(200)
as
begin
    Select t.idgv,t.email,t.gender,t.hoten,t.ngaysinh,t.phone,count(tc.idgv) as 'number_Class' from Teacher t
	join Teacher_Class tc on t.idgv=tc.idgv
    where t.hoten like N'%'+@name+'%' or t.email like  N'%'+@name+'%'  or t.phone like  N'%'+@name+'%'
	GROUP BY t.idgv,t.email,t.gender,t.hoten,t.ngaysinh,t.phone
end

GO
/****** Object:  StoredProcedure [dbo].[sp_updateAttendance]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateAttendance]
	@scheduleId int ,
	@idsv nvarchar(8),
	@currentDate datetime,
	@status nvarchar(10),
	@note nvarchar(255),
	@date date
as
begin
	update Attendance set status = @status , updatedDate = @currentDate , note = @note where scheduleId=@scheduleId and idsv=@idsv and createdDate >= @date
end

GO
/****** Object:  StoredProcedure [dbo].[sp_updateMark]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_updateMark]
   @idsv nvarchar(200),
   @idmon int,
   @type int,
   @diem float,
   @lanthi int,
   @ketqua nvarchar(200)
as
begin
    Update Mark set diem=@diem,ketqua=@ketqua where idsv=@idsv and idmon=@idmon and type=@type and lanthi=@lanthi
end


GO
/****** Object:  StoredProcedure [dbo].[sp_updateMark_Type]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_updateMark_Type]
   @id int,
   @name nvarchar(200)
as
begin
   Update Mark_type set name=@name where id=@id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_updateSchedule]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_updateSchedule]
	@id int,
	@subjectId int,
	@teacherId int,
	@classId nvarchar(20),
	@frameTime bit,
	@startTime Time,
	@endTime Time,
	@startDate date,
	@endDate date,
	@note nvarchar(255)
as
begin
	update schedule set subjectId = @subjectId,teacherId=@teacherId,classId=@classId,frameTime=@frameTime,startTime=@startTime,endTime=@endTime,startDate=@startDate,endDate=@endDate,note=@note where Id = @id
end

GO
/****** Object:  StoredProcedure [dbo].[sp_updateSem]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_updateSem]
    @idFaculty int ,
	@idmon int,
	@sem int,
	@year int,
	@soTinchi int
as
begin
   Update Sem set sem=@sem,year=@year,soTinchi=@soTinchi where idFaculty=@idFaculty and  idmon=@idmon
end


GO
/****** Object:  StoredProcedure [dbo].[sp_updateStudent]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_updateStudent]
	@idsv nvarchar(8),
	@hoten nvarchar(200),
	@ngaysinh date,
	@phone nvarchar(11),
	@email nvarchar(200),
	@diachi nvarchar(200),
	@gioitinh bit,
	@idlop nvarchar(20)
as
begin
    Update Student set hoten=@hoten,phone=@phone,email=@email,gioitinh=@gioitinh,ngaysinh=@ngaysinh,diachi=@diachi,idlop=@idlop where idsv=@idsv
end


GO
/****** Object:  StoredProcedure [dbo].[sp_updateSubject]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_updateSubject]
   @id int,
   @mon nvarchar(200),
   @idFaculty int
as
begin
   Update Subject set mon=@mon,idFaculty=@idFaculty where id=@id
end


GO
/****** Object:  StoredProcedure [dbo].[sp_updateTeacher]    Script Date: 1/22/2021 11:08:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[sp_updateTeacher]
    @idgv int,
    @hoten nvarchar(200),
	@phone nvarchar(11),
	@email nvarchar(100),
	@gender bit,
	@ngaysinh date
as
begin
    Update Teacher set hoten=@hoten,phone=@phone,email=@email,gender=@gender,ngaysinh=@ngaysinh where idgv=@idgv
end

